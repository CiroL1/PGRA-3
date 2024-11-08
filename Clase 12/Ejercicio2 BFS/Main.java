    public static void main(String[] args) {
        Ejercicio1BFS grafo = new Ejercicio1BFS();

        // Agrego aristas del grafo
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(1, 4);
        grafo.agregarArista(2, 5);
        grafo.agregarArista(3, 6);
        grafo.agregarArista(4, 7);
        grafo.agregarArista(4, 8);

        // Inicio del BFS desde el nodo 0
        grafo.bfs(0);
    }
}
