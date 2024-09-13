public static void main(String[] args) {

    Grafos grafo = new Grafos();

    grafo.crear("A");
    grafo.crear("B");
    grafo.crear("C");
    grafo.crear("D");

    grafo.apuntar("A", "B");
    grafo.apuntar("A", "C");
    grafo.apuntar("B", "D");

    System.out.println("\nRecorrido en preorden:");
    grafo.preorden("A");

    System.out.println("\nRecorrido en postorden:");
    grafo.postorden("A");
}