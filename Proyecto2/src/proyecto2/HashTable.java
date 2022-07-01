package proyecto2;

public class HashTable {
    private int lenght = 15;
    private Resumen [] tabla;
    
    public HashTable(){
        this.tabla = new Resumen[lenght];
        for (int i=0; i < lenght; i++){
            tabla[i] = null;
        }
    }
    
    public int HashFunction(String titulo){
        int hash = 0;
        for (int i=0; i < titulo.length(); i++){
            hash += titulo.charAt(i);
        }
        hash = hash % lenght;
        return hash;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public Resumen[] getTabla() {
        return tabla;
    }

    public void setTabla(Resumen[] tabla) {
        this.tabla = tabla;
    }
    
    
}
