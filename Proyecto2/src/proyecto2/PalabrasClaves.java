package proyecto2;

public class PalabrasClaves {
    private String palabra;
    private int frecuencia;
    
    public PalabrasClaves(String palabra){
        this.palabra = palabra;
        this.frecuencia = 0;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }
    
}
