import java.util.*;

class Nodo implements Comparable<Nodo> {
    int id;
    int tiempo; // Representa el tiempo de viaje acumulado desde el inicio

    public Nodo(int id, int tiempo) {
        this.id = id;
        this.tiempo = tiempo;
    }

    @Override
    public int compareTo(Nodo otro) {
        return Integer.compare(this.tiempo, otro.tiempo);
    }
}

public class Logistica {
    private int numCentros;
    private List<List<Nodo>> listaAdyacencia;

    // Inicializa el grafo con el número de centros
    public Logistica(int numCentros) {
        this.numCentros = numCentros;
        listaAdyacencia = new ArrayList<>();

        for (int i = 0; i < numCentros; i++) {
            listaAdyacencia.add(new ArrayList<>());
        }
    }

    // Agrega una carretera (arista) entre dos centros con el tiempo de viaje
    public void agregarRuta(int origen, int destino, int tiempo) {
        listaAdyacencia.get(origen).add(new Nodo(destino, tiempo));
        listaAdyacencia.get(destino).add(new Nodo(origen, tiempo)); // Si es bidireccional
    }

    // Aplica el algoritmo de Dijkstra para encontrar el tiempo mínimo de entrega
    public void aplicarDijkstra(int inicio) {
        int[] tiempoMinimo = new int[numCentros];
        Arrays.fill(tiempoMinimo, Integer.MAX_VALUE);
        tiempoMinimo[inicio] = 0;

        PriorityQueue<Nodo> pq = new PriorityQueue<>();
        pq.add(new Nodo(inicio, 0));

        while (!pq.isEmpty()) {
            Nodo actual = pq.poll();
            int idActual = actual.id;

            // Recorrer las carreteras conectadas al nodo actual
            for (Nodo adyacente : listaAdyacencia.get(idActual)) {
                int nuevoTiempo = tiempoMinimo[idActual] + adyacente.tiempo;

                if (nuevoTiempo < tiempoMinimo[adyacente.id]) {
                    tiempoMinimo[adyacente.id] = nuevoTiempo;
                    pq.add(new Nodo(adyacente.id, nuevoTiempo));
                }
            }
        }

        // Mostrar el resultado
        System.out.println("Tiempos mínimos de entrega desde el centro de distribución principal:");
        for (int i = 0; i < numCentros; i++) {
            System.out.println("Centro " + inicio + " a Centro " + i + ": " + (tiempoMinimo[i] == Integer.MAX_VALUE ? "No conectado" : tiempoMinimo[i] + " minutos"));
        }
    }
}
