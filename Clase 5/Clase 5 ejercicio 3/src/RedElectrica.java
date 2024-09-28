import java.util.*;

class Arista implements Comparable<Arista> {
    int origen;
    int destino;
    int peso;

    public Arista(int origen, int destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    @Override
    public int compareTo(Arista otra) {
        return this.peso - otra.peso;
    }
}

public class RedElectrica {
    private int numVertices;
    private List<List<Arista>> listaAdyacencia;

    // Inicializa el grafo con el número de vértices
    public RedElectrica(int numVertices) {
        this.numVertices = numVertices;
        listaAdyacencia = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            listaAdyacencia.add(new ArrayList<>());
        }
    }

    // Agrega una conexión (arista) entre dos vértices
    public void agregarConexion(int origen, int destino, int peso) {
        listaAdyacencia.get(origen).add(new Arista(origen, destino, peso));
        listaAdyacencia.get(destino).add(new Arista(destino, origen, peso));
    }

    // Aplica el algoritmo de Prim para encontrar el Árbol de Recubrimiento Mínimo
    public void aplicarPrim() {
        boolean[] visitado = new boolean[numVertices];
        PriorityQueue<Arista> pq = new PriorityQueue<>();
        List<Arista> mst = new ArrayList<>();
        int costoTotal = 0;

        // Comenzar desde el vértice 0
        visitado[0] = true;
        pq.addAll(listaAdyacencia.get(0));

        while (!pq.isEmpty()) {
            Arista arista = pq.poll();

            if (visitado[arista.destino]) continue;

            // Marca el vértice como visitado y agrega la arista al MST
            visitado[arista.destino] = true;
            mst.add(arista);
            costoTotal += arista.peso;

            // Agrega todas las aristas conectadas al nuevo vértice al PriorityQueue
            for (Arista adyacente : listaAdyacencia.get(arista.destino)) {
                if (!visitado[adyacente.destino]) {
                    pq.add(adyacente);
                }
            }
        }

        // Muestra el resultado
        System.out.println("Conexiones del Árbol de Recubrimiento Mínimo:");
        for (Arista arista : mst) {
            System.out.println("Estación " + arista.origen + " - Estación " + arista.destino + " con costo: " + arista.peso);
        }
        System.out.println("Costo total de la red de distribución eléctrica: " + costoTotal);
    }
}
