package proyecto2;

public class Main {
    public static void main(String[] args) {
        HashTable tabla = new HashTable();
        String titulo = "Complemento de software para el diseño de fundaciones.";
        String titulo2 = "Arquitectura referencial para mecanismos de Internacionalización y localización en PHP.";
        String titulo3 = "Sistema de diseño basado en Grid";
        String titulo4 = "GraphQL vs REST: una comparación desde la perspectiva de eficiencia de desempeño.";
        
        System.out.println(tabla.HashFunction(titulo));
        System.out.println(tabla.HashFunction(titulo2));
        System.out.println(tabla.HashFunction(titulo3));
        System.out.println(tabla.HashFunction(titulo4));
        
    }
}
