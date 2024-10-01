
public class LogisticaFloydWarshall {
    final static int INFINITO = 99999;  // Valor grande para simbolizar infinito

    public static void main(String[] args) {
        LogisticaFloydWarshall actividad = new LogisticaFloydWarshall();
        // Representación de los centros de distribución y sus conexiones
        // Cambia estos valores según sea necesario
        int matrizAdyacencia[][] = {
                            {0, 2, INFINITO, 5},  // Centro 1
                            {INFINITO, 0, INFINITO, 4}, // Centro 2
                            {INFINITO, INFINITO, 0, INFINITO}, // Centro 3
                            {INFINITO, INFINITO, 2, 0}   // Centro 4
                        };
        int numeroVertices = matrizAdyacencia.length;
        actividad.calcularFloydWarshall(matrizAdyacencia, numeroVertices);
    }

    void calcularFloydWarshall(int matrizAdyacencia[][], int numeroVertices) {
        int matrizDistancias[][] = new int[numeroVertices][numeroVertices];
        
        // Inicializa matriz de distancias
        for (int fila = 0; fila < numeroVertices; fila++) {
            for (int columna = 0; columna < numeroVertices; columna++) {
                matrizDistancias[fila][columna] = matrizAdyacencia[fila][columna];
            }
        }
        
        // Actualiza matriz de distancias
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
        
        //verificamos si hay ciclos negativos
        verificarCiclosNegativos(matrizDistancias, numeroVertices);
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
}
