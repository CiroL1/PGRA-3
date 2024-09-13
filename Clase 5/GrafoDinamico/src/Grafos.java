import java.util.*;

class Nodo {
    String nombre;
    List<Nodo> adjacentes;

    public Nodo(String nombre) {
        this.nombre = nombre;
        this.adjacentes = new ArrayList<>();
    }
}

public class Grafos {
    private Map<String, Nodo> nodos;

    public Grafos() {
        this.nodos = new HashMap<>();
    }

    // Método para crear un nodo
    public void crear(String nombre) {
        if (!nodos.containsKey(nombre)) {
            nodos.put(nombre, new Nodo(nombre));
            System.out.println("Nodo " + nombre + " creado.");
        } else {
            System.out.println("El nodo " + nombre + " ya existe.");
        }
    }
    // Método para apuntar un nodo A a B
    public void apuntar(String nombreA, String nombreB) {
        Nodo nodoA = nodos.get(nombreA);
        Nodo nodoB = nodos.get(nombreB);

        if (nodoA == null || nodoB == null) {
            System.out.println("Uno o ambos nodos no existen.");
            return;
        }

        if (!nodoA.adjacentes.contains(nodoB)) {
            nodoA.adjacentes.add(nodoB);
            System.out.println("Nodo " + nombreA + " ahora apunta a " + nombreB);
        } else {
            System.out.println("Nodo " + nombreA + " ya apunta a " + nombreB);
        }
    }
    // Método para recorrer en preorden
    public void preorden(String nombre) {
        Nodo nodo = nodos.get(nombre);
        if (nodo == null) {
            System.out.println("El nodo no existe.");
            return;
        }
        Set<String> visitados = new HashSet<>();
        preordenRecursivo(nodo, visitados);
    }
    private void preordenRecursivo(Nodo nodo, Set<String> visitados) {
        if (nodo == null || visitados.contains(nodo.nombre)) return;

        System.out.println(nodo.nombre); // Visita el nodo
        visitados.add(nodo.nombre);

        for (Nodo adj : nodo.adjacentes) {
            preordenRecursivo(adj, visitados);
        }
    }
    // Método para recorrer en postorden
    public void postorden(String nombre) {
        Nodo nodo = nodos.get(nombre);
        if (nodo == null) {
            System.out.println("El nodo no existe.");
            return;
        }
        Set<String> visitados = new HashSet<>();
        postordenRecursivo(nodo, visitados);
    }
    private void postordenRecursivo(Nodo nodo, Set<String> visitados) {
        if (nodo == null || visitados.contains(nodo.nombre)) return;

        for (Nodo adj : nodo.adjacentes) {
            postordenRecursivo(adj, visitados);
        }

        if (!visitados.contains(nodo.nombre)) {
            System.out.println(nodo.nombre); // Visita el nodo después de los hijos
            visitados.add(nodo.nombre);
        }
    }
}
