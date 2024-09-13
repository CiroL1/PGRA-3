import java.util.*;

public class Main {
    public static void main(String[] args) {

           
                Grafo g = new Grafo(6);

                g.addEdge(0, 1);
                g.addEdge(0, 2);
                g.addEdge(1, 3);
                g.addEdge(2, 4);
                g.addEdge(2, 5);

                System.out.println("Recorrido en preorden comenzando desde el vértice 0:");
                g.preOrder(0);

                System.out.println("\nRecorrido en postorden comenzando desde el vértice 0:");
                g.postOrder(0);
            }
        }

