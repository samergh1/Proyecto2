package proyecto2;

public class Main {
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        HashTable tabla = new HashTable();
        
        String titulo = "Complemento de software para el diseño de fundaciones.";
        String titulo2 = "Arquitectura referencial para mecanismos de Internacionalización y localización en PHP.";
        String titulo3 = "Sistema de diseño basado en Grid";
        String titulo4 = "GraphQL vs REST: una comparación desde la perspectiva de eficiencia de desempeño.";
        
        String autores = "Raquel Sandoval, Iván Loscher, Christian Guillén-Drija";
        String resumen = "El adelanto tecnológico presente hoy en día ha traído una gran cantidad de herramientas útiles para los ingenieros";
        String palabrasClaves = "fundaciones directas, AutoCAD, complemento, C#";
        
        Resumen investigacion = new Resumen(titulo, autores, resumen, palabrasClaves);
        //tabla.insertar(investigacion);
        //System.out.println(tabla.buscar("Complemento de software para el diseño de fundaciones.").getResumen());
        
        
        System.out.println(tabla.HashFunction(titulo));
        System.out.println(tabla.HashFunction(titulo2));
        System.out.println(tabla.HashFunction(titulo3));
        System.out.println(tabla.HashFunction(titulo4));
        
    }
}
