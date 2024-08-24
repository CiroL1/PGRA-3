public class QuickSortEx {
    public static void quickSort(int[] arr, int bajo, int alto){
        if (bajo < alto){
            int indice = particion(arr,bajo,alto);

            quickSort(arr,bajo,indice-1);
            quickSort(arr,indice+1,alto);
        }
    }
    public static int particion(int[] arr, int bajo, int alto){
        int pivote = arr[alto];
        int i = (bajo-1);

        for (int j = bajo; j < alto; j++){
            if (arr[j] <= pivote){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[alto];
        arr[alto] = temp;
        return i + 1;
    }
    public static void main(String[] args) {
        int[] arreglo = {3, 6, 8, 10, 1, 2, 7};

        System.out.println("Arreglo original:");
        imprimirArreglo(arreglo);

        // Llamada a QuickSort
        quickSort(arreglo, 0, arreglo.length - 1);

        System.out.println("Arreglo ordenado:");
        imprimirArreglo(arreglo);
    }

    // Método para imprimir el arreglo
    private static void imprimirArreglo(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
