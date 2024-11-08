package clase12.actividad3;

import java.util.*;

public class Grafo {
    private final Map<Integer, Almacen> almacenes;
    private final Map<Integer, List<Integer>> adyacencias;

    public Grafo() {
        this.almacenes = new HashMap<>();
        this.adyacencias = new HashMap<>();
    }

    // Agregar un almacén al grafo
    public void agregarAlmacen(Almacen almacen) {
        almacenes.put(almacen.getId(), almacen);
        adyacencias.putIfAbsent(almacen.getId(), new ArrayList<>());
    }
    // conectar dos almacenes entre si
    public void conectarAlmacenes(int idAlmacen1, int idAlmacen2) {
        if (almacenes.containsKey(idAlmacen1) && almacenes.containsKey(idAlmacen2)) {
            adyacencias.get(idAlmacen1).add(idAlmacen2);
            adyacencias.get(idAlmacen2).add(idAlmacen1); // Bidireccional
        } else {
            System.out.println("Uno o los dos almacenes no existen.");
        }
    }

     // recorrido en profundidad (DFS)
    public void recorridoDFS(int idAlmacenInicio) {
        Set<Integer> visitados = new HashSet<>();
        System.out.println("Recorrido DFS:");
        dfs(idAlmacenInicio, visitados);
    }

    private void dfs(int idAlmacen, Set<Integer> visitados) {
        visitados.add(idAlmacen);
        System.out.println(almacenes.get(idAlmacen));

        for (int vecino : adyacencias.get(idAlmacen)) {
            if (!visitados.contains(vecino)) {
                dfs(vecino, visitados);
            }
        }
    }
    
}
