import java.io.*;
import java.util.*;

public class Solution {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
        // Ordenar los precios de las flores en orden ascendente
        Arrays.sort(c);

        // Variable para almacenar el costo total mínimo
        int totalCost = 0;

        // Iteramos sobre el arreglo de precios desde el final (flores más caras)
        for (int i = 0; i < c.length; i++) {
            // Para cada flor, calculamos su costo considerando cuántas flores ha comprado el amigo
            // (i / k) incrementa cada vez que un amigo ha comprado k flores
            totalCost += (i / k + 1) * c[c.length - 1 - i];
        }

        return totalCost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // Mensaje para el usuario sobre qué ingresar

        System.out.println("Ingrese el número total de flores y el número de amigos, separados por un espacio.");

        // Leer la primera línea de entrada
        String[] nk = scanner.nextLine().split(" ");

        // Mensaje sobre la segunda línea
        System.out.println("Ahora, ingrese los precios de las flores, separados por espacios.");


        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        // Leer la segunda línea de entrada
        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        // Calcular el costo mínimo
        int minimumCost = getMinimumCost(k, c);

        // Imprimir el costo mínimo en la consola
        System.out.println("El costo mínimo para comprar todas las flores es: " + minimumCost);

        scanner.close();
    }
}
