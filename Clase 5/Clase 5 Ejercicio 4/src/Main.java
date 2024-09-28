public class Main {
    public static void main(String[] args) {
        // Número de centros de distribución
        int numCentros = 5;

        // Crear la red de logística
        Logistica logistica = new Logistica(numCentros);

        // Agregar rutas (aristas) con tiempos de viaje
        logistica.agregarRuta(0, 1, 10);
        logistica.agregarRuta(0, 2, 15);
        logistica.agregarRuta(1, 3, 12);
        logistica.agregarRuta(1, 4, 15);
        logistica.agregarRuta(2, 4, 10);
        logistica.agregarRuta(3, 4, 5);

        // Aplicar el algoritmo de Dijkstra desde el centro de distribución principal (vértice 0)
        logistica.aplicarDijkstra(0);
    }
}
