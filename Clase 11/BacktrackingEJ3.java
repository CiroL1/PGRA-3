public class BacktrackingEJ3 {
    private static final int N = 4; // Tamaño del tablero 4x4

    public static void main(String[] args) {
        char[][] tablero = new char[N][N];
        // Inicializamos el tablero con '-'
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tablero[i][j] = '-';
            }
        }
        // Iniciar la colocación de computadoras
        colocarComputadoras(tablero, 0);
    }

    private static void colocarComputadoras(char[][] tablero, int fila) {
        // Si hemos colocado las 4 computadoras, colocamos las impresoras
        if (fila == N) {
            colocarImpresoras(tablero, 0);
            return;
        }

        // Intentamos colocar una computadora en cada columna de la fila actual
        for (int col = 0; col < N; col++) {
            if (esSeguroComputadora(tablero, fila, col)) {
                tablero[fila][col] = 'C'; // Colocamos una computadora
                colocarComputadoras(tablero, fila + 1); // Recursivamente colocamos en la siguiente fila
                tablero[fila][col] = '-'; // Backtracking
            }
        }
    }

    private static void colocarImpresoras(char[][] tablero, int fila) {
        // Si hemos colocado las 4 impresoras, imprimimos la disposición
        if (fila == N) {
            imprimirTablero(tablero);
            return;
        }

        // Intentamos colocar una impresora en cada columna de la fila actual
        for (int col = 0; col < N; col++) {
            if (esSeguroImpresora(tablero, fila, col)) {
                tablero[fila][col] = 'I'; // Colocamos una impresora
                colocarImpresoras(tablero, fila + 1); // Recursivamente colocamos en la siguiente fila
                tablero[fila][col] = '-'; // Backtracking
            }
        }
    }

    private static boolean esSeguroComputadora(char[][] tablero, int fila, int col) {
        // Verificar si hay alguna computadora en la misma columna
        for (int i = 0; i < fila; i++) {
            if (tablero[i][col] == 'C') {
                return false;
            }
        }
        return true;
    }

    private static boolean esSeguroImpresora(char[][] tablero, int fila, int col) {
        // Verificar si hay alguna impresora en la misma columna
        for (int i = 0; i < fila; i++) {
            if (tablero[i][col] == 'I') {
                return false;
            }
        }
        // Verificar si hay alguna impresora en la misma columna donde hay una computadora
        for (int i = 0; i < N; i++) {
            if (tablero[i][col] == 'C') {
                return false;
            }
        }
        return true;
    }

    private static void imprimirTablero(char[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
