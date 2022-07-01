package proyecto2;

public class Resumen {
    private String titulo;
    private String autores;
    private String resumen;
    private String palabrasClaves;
    
    public Resumen(String titulo, String autores, String resumen, String palabrasClaves){
        this.titulo = titulo;
        this.autores = autores;
        this.resumen = resumen;
        this.palabrasClaves = palabrasClaves;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getPalabrasClaves() {
        return palabrasClaves;
    }

    public void setPalabrasClaves(String palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
    }
    
    
    
}
