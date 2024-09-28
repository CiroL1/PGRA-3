public class Main {
    public static void main(String[] args) {
        // Crear un grafo con capacidad para 5 vértices
        GrafoMatriz grafo = new GrafoMatriz(5);

        // Agregar vértices
        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");

        // Agregar aristas
        grafo.agregarArista("A", "B");
        grafo.agregarArista("A", "C");
        grafo.agregarArista("B", "D");

        // Verificar si existe una arista
        System.out.println("¿Existe arista de A a B? " + grafo.verificarArista("A", "B"));
        System.out.println("¿Existe arista de A a D? " + grafo.verificarArista("A", "D"));

        // Listar vértices adyacentes
        grafo.listarAdyacentes("A");
        grafo.listarAdyacentes("B");

        // Contar grados de entrada y salida
        System.out.println("Grado de salida de A: " + grafo.contarGradoSalida("A"));
        System.out.println("Grado de entrada de D: " + grafo.contarGradoEntrada("D"));

        // Eliminar una arista
        grafo.eliminarArista("A", "B");
        System.out.println("¿Existe arista de A a B después de eliminarla? " + grafo.verificarArista("A", "B"));
    }
}
