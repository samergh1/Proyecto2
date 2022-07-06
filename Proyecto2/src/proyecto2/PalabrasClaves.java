package proyecto2;

public class PalabrasClaves {
    private String palabra;
    private int frecuencia;
    private String titulo;

    public PalabrasClaves(String palabra, String titulo) {
        this.palabra = palabra;
        this.frecuencia = 0;
        this.titulo = titulo;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
}
