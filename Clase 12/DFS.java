import java.util.*;

public class DFS {
    private Map<Integer, List<Integer>> grafo = new HashMap<>();

    // Método para agregar una arista al grafo
    public void agregarArista(int origen, int destino) {
        grafo.computeIfAbsent(origen, k -> new ArrayList<>()).add(destino);
        grafo.computeIfAbsent(destino, k -> new ArrayList<>()).add(origen);
    }

    // Método principal de DFS
    public void dfs(int nodoInicial) {
        Set<Integer> visitado = new HashSet<>(); // Conjunto para almacenar los nodos visitados
        dfsRecursivo(nodoInicial, visitado);
    }

    // Método recursivo de DFS
    private void dfsRecursivo(int nodo, Set<Integer> visitado) {
        visitado.add(nodo); // Marcar el nodo como visitado
        System.out.println("Visitando nodo: " + nodo);

        // Explorar vecinos no visitados
        for (int vecino : grafo.getOrDefault(nodo, Collections.emptyList())) {
            if (!visitado.contains(vecino)) {
                dfsRecursivo(vecino, visitado);
            }
        }
    }
}

