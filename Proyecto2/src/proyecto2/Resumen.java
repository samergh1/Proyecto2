package proyecto2;

public class Resumen {
    private String titulo;
    private String autores;
    private String cuerpoResumen;
    private String palabrasClaves;
    
    public Resumen(String titulo, String autores, String cuerpoResumen, String palabrasClaves){
        this.titulo = titulo;
        this.autores = autores;
        this.cuerpoResumen = cuerpoResumen;
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
        return cuerpoResumen;
    }

    public void setResumen(String cuerpoResumen) {
        this.cuerpoResumen = cuerpoResumen;
    }

    public String getPalabrasClaves() {
        return palabrasClaves;
    }

    public void setPalabrasClaves(String palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
    }
    
    
    
}
