package proyecto2;

import javax.swing.JOptionPane;

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
        int tituloLength = titulo.length();
        int hash = 0;
        for (int i=0; i < tituloLength; i++){
            hash += titulo.charAt(i);
        }
        hash = hash % lenght;
        return hash;
    }
    
    public void insertar(Resumen resumen){
        int posicion;
        posicion = HashFunction(resumen.getTitulo());
        this.tabla[posicion] = resumen;
    }
    
    public Resumen buscar(String titulo){
        int posicion;
        posicion = this.HashFunction(titulo);
        
        if (this.tabla[posicion] != null){
            if (this.tabla[posicion].getTitulo().equals(titulo)){
               Resumen resumen;
                resumen = this.tabla[posicion];
                return resumen; 
            }           
        }else{
            JOptionPane.showMessageDialog(null, "El resumen que trata de buscar no existe"); 
        }
        return null;
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
