public class Main {
    public static void main(String[] args) {
        Lista<String> frutas = new ListaEnlazada<>();

        System.out.println("--- 1. Agregando elementos ---");
        frutas.agregar("Manzana");
        frutas.agregar("Plátano");
        frutas.agregar("Naranja");
        System.out.println("Lista: " + frutas);

        System.out.println("\n--- 2. Insertando en posición 1 (Fresa) ---");
        frutas.insertar(1, "Fresa");
        System.out.println("Lista: " + frutas);

        System.out.println("\n--- 3. Consultas ---");
        System.out.println("Elemento en índice 2: " + frutas.obtener(2));
        System.out.println("¿Contiene 'Fresa'?: " + frutas.contiene("Fresa"));
        System.out.println("¿Contiene 'Uva'?: " + frutas.contiene("Uva"));
        System.out.println("Tamaño actual: " + frutas.tamano());

        System.out.println("\n--- 4. Eliminación ---");
        System.out.println("Eliminando índice 0: " + frutas.eliminar(0));
        System.out.println("Lista tras eliminar índice 0: " + frutas);

        boolean eliminado = frutas.eliminarElemento("Plátano");
        System.out.println("¿Se eliminó 'Plátano'?: " + eliminado);
        System.out.println("Lista final: " + frutas);
    }
}