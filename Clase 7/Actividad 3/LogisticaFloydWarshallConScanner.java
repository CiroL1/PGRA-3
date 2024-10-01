import java.util.Scanner;

public class LogisticaFloydWarshallConScanner {
    final static int INFINITO = 99999;  // Valor alto para simbolizar el infinito

    public static void main(String[] args) {
        LogisticaFloydWarshallConScanner actividad = new LogisticaFloydWarshallConScanner();

        // centros de distribución y sus conexiones
        int matrizAdyacencia[][] = {
            {0, 2, INFINITO, 5},  // Centro 1
            {INFINITO, 0, INFINITO, 4}, // Centro 2
            {INFINITO, INFINITO, 0, INFINITO}, // Centro 3
            {INFINITO, INFINITO, 2, 0}   // Centro 4
        };
        int numeroVertices = matrizAdyacencia.length;

        // Calculamos distancias y caminos
        int[][] matrizDistancias = actividad.calcularFloydWarshall(matrizAdyacencia, numeroVertices);

        // Verificarmossi hay ciclos negativos
        actividad.verificarCiclosNegativos(matrizDistancias, numeroVertices);

        //scanner 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el vértice de origen (1 a " + numeroVertices + "): ");
        int origen = scanner.nextInt() - 1; // Restar 1 para índice base 0
        System.out.print("Ingrese el vértice de destino (1 a " + numeroVertices + "): ");
        int destino = scanner.nextInt() - 1; // Restar 1 para índice base 0

        // Imprimimos el camino más corto entre origen y destino
        actividad.imprimirCamino(matrizDistancias, origen, destino);
        scanner.close();
    }

    int[][] calcularFloydWarshall(int matrizAdyacencia[][], int numeroVertices) {
        int matrizDistancias[][] = new int[numeroVertices][numeroVertices];
        
        // Inicializamos matriz de distancias
        for (int fila = 0; fila < numeroVertices; fila++) {
            for (int columna = 0; columna < numeroVertices; columna++) {
                matrizDistancias[fila][columna] = matrizAdyacencia[fila][columna];
            }
        }
        
        // Actualizamos matriz de distancias
        for (int intermedio = 0; intermedio < numeroVertices; intermedio++) {
            for (int origen = 0; origen < numeroVertices; origen++) {
                for (int destino = 0; destino < numeroVertices; destino++) {
                    if (matrizDistancias[origen][intermedio] != INFINITO && matrizDistancias[intermedio][destino] != INFINITO &&
                        matrizDistancias[origen][intermedio] + matrizDistancias[intermedio][destino] < matrizDistancias[origen][destino]) {
                        matrizDistancias[origen][destino] = matrizDistancias[origen][intermedio] + matrizDistancias[intermedio][destino];
                    }
                }
            }
        }

        // Mostramos matriz de distancias
        imprimirMatriz(matrizDistancias, numeroVertices);
        
        return matrizDistancias;
    }

    void imprimirMatriz(int matrizDistancias[][], int numeroVertices) {
        System.out.println("Matriz de distancias más cortas entre cada par de centros de distribución:");
        for (int fila = 0; fila < numeroVertices; fila++) {
            for (int columna = 0; columna < numeroVertices; columna++) {
                if (matrizDistancias[fila][columna] == INFINITO)
                    System.out.print("INF ");
                else
                    System.out.print(matrizDistancias[fila][columna] + "   ");
            }
            System.out.println();
        }
    }

    void verificarCiclosNegativos(int matrizDistancias[][], int numeroVertices) {
        boolean hayCicloNegativo = false;
        for (int i = 0; i < numeroVertices; i++) {
            if (matrizDistancias[i][i] < 0) {
                hayCicloNegativo = true;
                break;
            }
        }

        if (hayCicloNegativo) {
            System.out.println("Se han detectado ciclos negativos en el sistema de rutas, lo que podría generar oportunidades de ahorro sin límite.");
        } else {
            System.out.println("No se han encontrado ciclos negativos en el sistema de rutas.");
        }
    }

    void imprimirCamino(int matrizDistancias[][], int origen, int destino) {
    if (matrizDistancias[origen][destino] == INFINITO) {
        System.out.println("No hay un camino disponible entre el origen y el destino.");
        return;
    }

    System.out.println("El tiempo mínimo de entrega desde el centro de distribución " + (origen + 1) + " hasta el centro " + (destino + 1) + " es: " + matrizDistancias[origen][destino] + " minutos.");
    }
}
