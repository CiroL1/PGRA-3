public class MergeSortEx {
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;

        int[] izq = new int[mid];
        int[] der = new int[arr.length - mid];

        for (int i = 0; i < mid; i++) {
            izq[i] = arr[i];
        }

        for (int i = mid; i < arr.length; i++) {
            der[i-mid] = arr[i];
        }

        mergeSort(izq);
        mergeSort(der);

        merge(arr, izq, der);
    }

    public static void merge(int[]arr, int[] izq, int[] der) {
        int i = 0, j = 0, k = 0;

        while (i < izq.length && j < der.length) {
            if (izq[i] <= der[j]) {
                arr[k++] = izq[i++];
            } else {
                arr[k++] = der[j++];
            }
        }

        while (i < izq.length) {
            arr[k++] = izq[i++];
        }
        while (j < der.length) {
            arr[k++] = der[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,4,1,7,9,3,6,5,8};
        System.out.println("Arreglo original:");
        imprimirArreglo(arr);

        // Llamada a MergeSort
        mergeSort(arr);

        System.out.println("Arreglo ordenado:");
        imprimirArreglo(arr);
    }

    // Método para imprimir el arreglo
    private static void imprimirArreglo(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
