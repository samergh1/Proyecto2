package proyecto2;

public class Resumen {
    private String titulo;
    private String autores;
    private String cuerpoResumen;
    private PalabrasClaves  palabrasClaves;
    
    public Resumen(String titulo, String autores, String cuerpoResumen, String palabrasClaves){
        this.titulo = titulo;
        this.autores = autores;
        this.cuerpoResumen = cuerpoResumen;
        this.palabrasClaves = new PalabrasClaves(palabrasClaves, titulo);
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
        return palabrasClaves.getPalabra();
    }

    public void setPalabrasClaves(String palabrasClave) {
        this.palabrasClaves.setPalabra(palabrasClave);
    }
    
    
    
}
