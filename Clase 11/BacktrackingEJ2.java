public class BacktrackingEJ2 {
    private static final int N = 4; // Tamaño del cuarto 4x4

    public static void main(String[] args) {
        // Matriz para la disposición
        char[][] cuarto = new char[N][N];
        // Llenar el cuarto con '-'
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cuarto[i][j] = '-';
            }
        }
        // Iniciar la búsqueda de disposiciones
        colocarElementos(cuarto, 0, 0);
    }

    private static void colocarElementos(char[][] cuarto, int fila, int elementosColocados) {
        // Verificamos si ya colocamos los dos elementos (escritorio y silla)
        if (elementosColocados == 2) {
            imprimirCuarto(cuarto);
            return;
        }

        // Recorremos cada celda del cuarto a partir de la posición actual
        for (int i = fila; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (esSeguro(cuarto, i, j)) {
                    // Colocar un elemento en la posición (i, j)
                    cuarto[i][j] = elementosColocados == 0 ? 'E' : 'S'; // 'E' para escritorio, 'S' para silla
                    // Intentar colocar el siguiente elemento
                    colocarElementos(cuarto, i + 1, elementosColocados + 1);
                    // Retirar el elemento para backtracking
                    cuarto[i][j] = '-';
                }
            }
        }
    }

    private static boolean esSeguro(char[][] cuarto, int fila, int col) {
        // Verificar si hay un elemento en la misma fila
        for (int i = 0; i < N; i++) {
            if (cuarto[fila][i] != '-' || cuarto[i][col] != '-') {
                return false;
            }
        }
        return true;
    }

    private static void imprimirCuarto(char[][] cuarto) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(cuarto[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
