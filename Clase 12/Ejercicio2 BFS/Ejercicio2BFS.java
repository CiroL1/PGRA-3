import java.util.*;

public class Ejercicio2BFS {
    private Map<Integer, List<Integer>> grafo = new HashMap<>();

    // agregar una arista al grafo
    public void agregarArista(int origen, int destino) {
        grafo.computeIfAbsent(origen, k -> new ArrayList<>()).add(destino);
        grafo.computeIfAbsent(destino, k -> new ArrayList<>()).add(origen);
    }

    // metodo principal de BFS
    public void bfs(int nodoInicial) {
        Set<Integer> visitado = new HashSet<>();
        Queue<Integer> cola = new LinkedList<>();

        // inicio de BFS desde el nodo inicial
        visitado.add(nodoInicial);
        cola.add(nodoInicial);

        while (!cola.isEmpty()) {
            int nodo = cola.poll();
            System.out.println("Visitando nodo: " + nodo);

            // vecinos no visitados
            for (int vecino : grafo.getOrDefault(nodo, Collections.emptyList())) {
                if (!visitado.contains(vecino)) {
                    visitado.add(vecino);
                    cola.add(vecino);
                }
            }
        }
    }
