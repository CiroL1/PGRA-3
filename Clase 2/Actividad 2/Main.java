import java.io.*;
import java.util.Arrays;

public class Main {
    public static int BusquedaBinaria(int[] arr, int n){
        int izq = 0;
        int der = arr.length - 1;

        while (izq <= der){
            int medio = izq + (der - izq) / 2;
            if (arr[medio] == n){
                return medio;
            }
            if (arr[medio] < n){
                izq = medio + 1;
            } else {
                der = medio - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException{
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("Array: " + Arrays.toString(arr));
        BufferedReader en = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Inserta objetivo a buscar? ");
        int obj = Integer.parseInt(en.readLine());
        int resultado = BusquedaBinaria(arr, obj);
        if (resultado == -1) {
            System.out.println("Elemento no encontrado en el arreglo.");
        } else {
            System.out.println("Elemento encontrado en el índice: " + resultado);
        }
    }
}
