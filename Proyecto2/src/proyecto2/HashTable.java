package proyecto2;

import javax.swing.JOptionPane;

public class HashTable {
    private int lenght = 15;
    private Resumen [] tabla;
    private PalabrasClaves [] tablaPalabras;
    
    /**
     * Constructor para la tabla de resumenes
     */
    public HashTable(){
        this.tabla = new Resumen[this.lenght];
        for (int i=0; i < this.lenght; i++){
            this.tabla[i] = null;
        }
    }
    
    /**
     * Constructor para la tabla de palabras clave
     * @param longitud
     */
    public HashTable(int longitud){
        this.tablaPalabras = new PalabrasClaves[longitud];
        for (int i=0; i < longitud; i++){
            this.tablaPalabras[i] = null;
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
    
    public boolean insertar(Resumen resumen){
        int posicion;
        posicion = HashFunction(resumen.getTitulo());
        if (this.tabla[posicion] != null){
            if (this.tabla[posicion].getTitulo().equals(resumen.getTitulo())){
                JOptionPane.showMessageDialog(null, "No puede insertar el mismo resumen dos veces");
                return false;
            }
        } else{
            this.tabla[posicion] = resumen;
            JOptionPane.showMessageDialog(null, "Archivo cargado correctamente");
            return true;
        }
        return false;
    }
    
    public void insertarPalabras(PalabrasClaves palabra){
        int posicion;
        posicion = HashFunction(palabra.getPalabra());
        this.tablaPalabras[posicion] = palabra;
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
