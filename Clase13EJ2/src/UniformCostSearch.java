import java.util.*;

class Node implements Comparable<Node> {
    String name;
    int cost;

    Node(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.cost, other.cost);
    }
}

public class UniformCostSearch {
    public static List<String> uniformCostSearch(Map<String, Map<String, Integer>> graph, String start, String goal) {
        // Cola de prioridad para expandir el nodo con menor costo acumulado
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        // Map para registrar el costo mínimo hasta cada nodo
        Map<String, Integer> costs = new HashMap<>();
        for (String node : graph.keySet()) {
            costs.put(node, Integer.MAX_VALUE);
        }
        costs.put(start, 0);

        // Map para rastrear el camino más económico
        Map<String, String> predecessors = new HashMap<>();

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // Si llegamos al destino, terminamos
            if (current.name.equals(goal)) {
                break;
            }

            // Explorar los vecinos
            for (Map.Entry<String, Integer> neighborEntry : graph.get(current.name).entrySet()) {
                String neighbor = neighborEntry.getKey();
                int cost = neighborEntry.getValue();
                int newCost = current.cost + cost;

                // Si el nuevo costo es menor, lo actualizamos
                if (newCost < costs.get(neighbor)) {
                    costs.put(neighbor, newCost);
                    predecessors.put(neighbor, current.name);
                    queue.add(new Node(neighbor, newCost));
                }
            }
        }

        // Reconstruir el camino desde el objetivo hasta el inicio
        List<String> path = new ArrayList<>();
        String step = goal;
        while (step != null) {
            path.add(0, step);
            step = predecessors.get(step);
        }

        // Si no existe un camino al nodo objetivo
        if (path.size() == 1 && !path.get(0).equals(start)) {
            return Arrays.asList("No existe un camino entre el inicio y el objetivo.");
        }

        return path;
    }

    public static void main(String[] args) {
        // Grafo de ejemplo
        Map<String, Map<String, Integer>> graph = new HashMap<>();

        // Inicializar el grafo con nodos y costos
        graph.put("A", Map.of("B", 100, "C", 300));
        graph.put("B", Map.of("C", 50, "D", 200));
        graph.put("C", Map.of("D", 100));
        graph.put("D", Map.of());

        String start = "A";
        String goal = "D";

        // Llamar al algoritmo UCS y mostrar los resultados
        List<String> path = uniformCostSearch(graph, start, goal);
        int totalCost = path.size() > 1 ? graph.get("A").get("B") + graph.get("B").get("C") + graph.get("C").get("D") : 0;

        System.out.println("Ruta más económica: " + String.join(" -> ", path));
        System.out.println("Costo total: " + totalCost);
    }
}