import java.util.Arrays;

public class ElementosMasGrandes {
    public static int[] encontrarNMasGrandes(int[] arr, int n) {
        return quickSelect(arr, 0, arr.length - 1, n);
    }

    private static int[] quickSelect(int[] arr, int inicio, int fin, int n) {
        if (inicio >= fin) {
            int[] resultado = new int[n];
            System.arraycopy(arr, arr.length - n, resultado, 0, n);
            return resultado;
        }

        int pivote = particion(arr, inicio, fin);

        int tamanoDerecha = fin - pivote + 1; // Tamaño de la sublista de elementos mayores o iguales al pivote

        if (tamanoDerecha == n) {
            return Arrays.copyOfRange(arr, pivote, fin + 1);
        } else if (tamanoDerecha > n) {
            return quickSelect(arr, pivote + 1, fin, n);
        } else {
            int[] resultado = new int[n];
            System.arraycopy(arr, pivote, resultado, 0, tamanoDerecha);
            int[] subResultado = quickSelect(arr, inicio, pivote - 1, n - tamanoDerecha);
            System.arraycopy(subResultado, 0, resultado, tamanoDerecha, n - tamanoDerecha);
            return resultado;
        }
    }

    private static int particion(int[] arr, int inicio, int fin) {
        int pivote = arr[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (arr[j] <= pivote) {
                i++;
                intercambiar(arr, i, j);
            }
        }

        intercambiar(arr, i + 1, fin);
        return i + 1;
    }
    
    private static void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] lista = {3, 1, 4, 5, 9, 2, 6, 8, 7};
        int n = 3;

        int[] mayores = encontrarNMasGrandes(lista, n);
        System.out.println("Los " + n + " elementos más grandes son: " + Arrays.toString(mayores));
    }
}

//Complejidad Temporal:
//En el mejor de los casos, este algoritmo tiene una complejidad de O(n),
// similar al algoritmo de QuickSelect.
