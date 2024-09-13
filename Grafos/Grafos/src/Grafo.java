import java.util.Iterator;
import java.util.LinkedList;

public class Grafo {

        private int V; // Para guardar la cantidad de vertices del grafo
        private LinkedList<Integer> adj[]; // Listas con los valores de los nodos

        Grafo(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        // Método para añadir una arista al grafo
        void addEdge(int v, int w) {
            adj[v].add(w); // Añadir w a la lista de v.
        }

        // Método para recorrer el grafo en preorden
        void preOrderUtil(int v, boolean visited[]) {
            visited[v] = true;
            System.out.print(v + " "); // Entrar el nodo antes de sus nodos hijos

            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n])
                    preOrderUtil(n, visited);
            }
        }

        void preOrder(int v) {
            boolean visited[] = new boolean[V];
            preOrderUtil(v, visited);
        }

        // Método para recorrer el grafo en postorden
        void postOrderUtil(int v, boolean visited[]) {
            visited[v] = true;

            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n])
                    postOrderUtil(n, visited);
            }

            System.out.print(v + " "); // Entrar el nodo después de sus hijos
        }

        void postOrder(int v) {
            boolean visited[] = new boolean[V];
            postOrderUtil(v, visited);
        }

    }
