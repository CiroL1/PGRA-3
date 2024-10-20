public class BacktrackingEJ1 {
    private static final int N = 4; // Tamaño del tablero 4x4

    public static void main(String[] args) {
        // Matriz para el tablero de ajedrez
        int[][] tablero = new int[N][N];
        // Iniciar la búsqueda
        colocarReinas(tablero, 0, 0, 0);
    }

    private static void colocarReinas(int[][] tablero, int fila, int col, int reinasColocadas) {
        if (reinasColocadas == 2) {
            // Si ya colocamos las 2 reinas, imprimimos el tablero
            imprimirTablero(tablero);
            return;
        }

        // Recorremos cada celda del tablero a partir de la posición actual
        for (int i = fila; i < N; i++) {
            for (int j = (i == fila ? col : 0); j < N; j++) {
                if (esSeguro(tablero, i, j)) {
                    // Colocar la reina en la posición (i, j)
                    tablero[i][j] = 1;
                    // Intentar colocar la siguiente reina
                    colocarReinas(tablero, i, j + 1, reinasColocadas + 1);
                    // Retirar la reina para backtracking
                    tablero[i][j] = 0;
                }
            }
        }
    }

    private static boolean esSeguro(int[][] tablero, int fila, int col) {
        // Verificar si hay otra reina en la misma fila
        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] == 1 || tablero[i][col] == 1) {
                return false;
            }
        }

        // Verificar diagonales
        for (int i = -N; i < N; i++) {
            int diag1Fila = fila + i;
            int diag1Col = col + i;
            int diag2Fila = fila + i;
            int diag2Col = col - i;
            if ((diag1Fila >= 0 && diag1Fila < N && diag1Col >= 0 && diag1Col < N && tablero[diag1Fila][diag1Col] == 1) ||
                    (diag2Fila >= 0 && diag2Fila < N && diag2Col >= 0 && diag2Col < N && tablero[diag2Fila][diag2Col] == 1)) {
                return false;
            }
        }

        return true;
    }

    private static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tablero[i][j] == 1 ? "Q " : "- ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
