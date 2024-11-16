import java.util.*;

public class DFS {
    private Map<Integer, List<Integer>> grafo = new HashMap<>();


    public void agregarArista(int origen, int destino) {
        grafo.computeIfAbsent(origen, k -> new ArrayList<>()).add(destino);
        grafo.computeIfAbsent(destino, k -> new ArrayList<>()).add(origen);
    }


    public void dfs(int nodoInicial) {
        Set<Integer> visitado = new HashSet<>(); 
        dfsRecursivo(nodoInicial, visitado);
    }


    private void dfsRecursivo(int nodo, Set<Integer> visitado) {
        visitado.add(nodo); 
        System.out.println("Visitando nodo: " + nodo);


        for (int vecino : grafo.getOrDefault(nodo, Collections.emptyList())) {
            if (!visitado.contains(vecino)) {
                dfsRecursivo(vecino, visitado);
            }
        }
    }
}

