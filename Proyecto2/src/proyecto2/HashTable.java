package proyecto2;

import javax.swing.JOptionPane;

public class HashTable {

    private int lenght = 15;
    private Resumen[] tabla;
    private PalabrasClaves[] tablaPalabras;

    /**
     * Constructor para la tabla de resumenes
     */
    public HashTable() {
        this.tabla = new Resumen[this.lenght];
        for (int i = 0; i < this.lenght; i++) {
            this.tabla[i] = null;
        }
    }

    /**
     * Constructor para la tabla de palabras clave
     *
     * @param longitud
     */
    public HashTable(int longitud) {
        this.tablaPalabras = new PalabrasClaves[longitud];
        for (int i = 0; i < longitud; i++) {
            this.tablaPalabras[i] = null;
        }
    }

    /**
     * Funcion hash para la tabla de objetos resumen
     *
     * @param titulo
     * @return
     */
    public int HashFunction(String titulo) {
        int tituloLength = titulo.length();
        int hash = 0;
        for (int i = 0; i < tituloLength; i++) {
            hash += titulo.charAt(i);
        }
        hash = hash % lenght;
        return hash;
    }

    /**
     * Funcion hash para la tabla de objetos PalabrasClaves
     *
     * @param palabraClave
     * @param longitud
     * @return
     */
    public int HashFunctionPalabras(String palabraClave, int longitud) {
        int palabraLenght = palabraClave.length();
        int hash = 0;
        for (int i = 0; i < palabraLenght; i++) {
            hash += palabraClave.charAt(i);
        }
        hash = hash % longitud;
        return hash;
    }

    /**
     * Metodo para insertar un objeto resumen a la tabla de resumenes
     *
     * @param resumen Objeto resumen a insertar
     * @return Retorna true si se inserto el objeto y false si no se pudo
     * insertar
     */
    public boolean insertar(Resumen resumen) {
        int posicion;
        posicion = HashFunction(resumen.getTitulo());
        if (this.tabla[posicion] != null) {
            if (this.tabla[posicion].getTitulo().equals(resumen.getTitulo())) {
                JOptionPane.showMessageDialog(null, "No puede insertar el mismo resumen dos veces");
                return false;
            }
        } else {
            this.tabla[posicion] = resumen;
            return true;
        }
        return false;
    }

    /**
     * Metodo para insertar un objeto PalabrasClaves a la tabla de palabras
     * claves
     *
     * @param palabra Objeto palabra a insertar
     */
    public void insertarPalabras(PalabrasClaves palabra) {
        int posicion;
        posicion = this.HashFunctionPalabras(palabra.getPalabra(), tablaPalabras.length);
        this.tablaPalabras[posicion] = palabra;
    }

    /**
     * Funcion para buscar un resumen
     *
     * @param titulo String al que se le aplica la funcion hash para buscar su
     * indice y acceder al resumen
     * @return retorna objeto resumen
     */
    public Resumen buscar(String titulo) {
        int posicion;
        posicion = this.HashFunction(titulo);

        if (this.tabla[posicion] != null) {
            if (this.tabla[posicion].getTitulo().equals(titulo)) {
                Resumen resumen;
                resumen = this.tabla[posicion];
                return resumen;
            }
        } else {
            JOptionPane.showMessageDialog(null, "El resumen que trata de buscar no existe");
        }
        return null;
    }

    /**
     * Funcion para buscar un titulo a partir de una palabra clave
     *
     * @param palabraClave
     * @return retorna un String con el titulo del resumen al que pertenece la
     * palabra clave
     */
    public String buscarTitulo(String palabraClave) {
        int posicion;
        posicion = this.HashFunctionPalabras(palabraClave, tablaPalabras.length);
        if (this.tablaPalabras[posicion] != null) {
            if (this.tablaPalabras[posicion].getPalabra().equals(palabraClave)) {
                String titulo = this.tablaPalabras[posicion].getTitulo();
                return titulo;
            }
        } else {
            JOptionPane.showMessageDialog(null, "El titulo que trata de buscar no existe");
        }
        return null;
    }

    /**
     * Funcion para buscar la frecuencia con la que aparece una palabra clave en
     * el resumen
     *
     * @param palabras cuerpo del resumen separado por espacios y convertido en
     * array
     * @param palabrasClaves array de las palabras claves que tiene el resumen
     */
    public void buscarFrecuenciaPalabra(String[] palabras, String[] palabrasClaves) {
        int posicion;
        for (int i = 0; i < palabrasClaves.length; i++) {
            for (int j = 0; j < palabras.length; j++) {

                if (palabrasClaves[i].contains(" ") && palabrasClaves[i].contains(palabras[j])) {
                    String[] palabrasArray = palabrasClaves[i].split(" ");
                    boolean logico = true;

                    for (int k = 0; k < palabrasArray.length; k++) {
                        logico = palabras[j].equals(palabrasArray[k]);
                        j++;
                    }

                    if (logico) {
                        posicion = this.HashFunctionPalabras(palabrasClaves[i], this.tablaPalabras.length);
                        this.tablaPalabras[posicion].setFrecuencia(this.tablaPalabras[posicion].getFrecuencia() + 1);
                    }

                } else if (palabrasClaves[i].contains(palabras[j])) {
                    posicion = this.HashFunctionPalabras(palabras[j], this.tablaPalabras.length);
                    if (this.tablaPalabras[posicion] != null) {
                        if (this.tablaPalabras[posicion].getPalabra().equals(palabras[j])) {
                            this.tablaPalabras[posicion].setFrecuencia(this.tablaPalabras[posicion].getFrecuencia() + 1);
                        }
                    }
                }
            }
        }
    }

    /**
     * Funcion para buscar los titulos de todos los resumenes en los que
     * participa el autor
     *
     * @param autor
     * @return retorna array de Strings con todos los titulos
     */
    public String[] buscarTitulosPorAutor(String autor) {
        String titulos = "";
        int aux = this.tabla.length;
        for (int i = 0; i < aux; i++) {
            if (tabla[i] != null) {
                String[] autores = tabla[i].getAutores().split("\n");
                int aux2 = autores.length;
                for (int j = 0; j < aux2; j++) {
                    if (autores[j].equals(autor)) {
                        titulos += (tabla[i].getTitulo() + "--");

                    }
                }
            }
        }

        if (titulos.equals("")) {
            return null;
        } else {
            String[] arrTitulos = titulos.split("--");
            return arrTitulos;
        }
    }

    /**
     * Funcion para imprimir el contenido de un resumen
     *
     * @param titulo
     * @return retorna un String con la informacion que contiene el resumen
     */
    public String imprimirResumen(String titulo) {
        String cadena = "";
        Resumen resumen = this.buscar(titulo);
        cadena += resumen.getTitulo() + "\n\n" + "Autores: \n" + resumen.getAutores() + "\n\n" + "Resumen: \n" + resumen.getResumen() + "\n\n" + "Palabras claves: \n" + resumen.getPalabrasClaves();
        return cadena;
    }
    
    /**
     * Funcion para imprimir la frecuencia de las palabras claves
     * @param palabrasClaves
     * @return 
     */
    public String imprimirTablaPalabras(String[] palabrasClaves) {
        String cadena = "";
        int posicion;
        for (int i = 0; i < palabrasClaves.length; i++) {
            posicion = this.HashFunctionPalabras(palabrasClaves[i], this.tablaPalabras.length);
            if (tablaPalabras[posicion] != null) {
                cadena += "- " + tablaPalabras[posicion].getPalabra() + ": La palabra aparece " + tablaPalabras[posicion].getFrecuencia() + " veces" + "\n";
            }
        }
        return cadena;
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
