public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int max = -9999; //1
        for (int i = 0; i < arr.length; i++) { // 1 + 2(n +1) + n = 3 + 3n
            if (arr[i] > max) { //n
                max = arr[i]; //2
            }
        }
        System.out.println("maximo: " + max);//2
    }
    // 1 + 3 + 3n + n(n + 2) + 2 = n² + 5n + 6
    // Queremos demostrar que f(n) = n² + 5n + 6 pertenece a O(n²)
    // n² + 5n + 6 <= c n² buscando un c y n0
    // n²/n² + 5n/n² + 6/n² <= cn²/n²
    // simplificando 1 + 5n/n² + 6/n² <= c Elegimos c = 12
    // Para n = 1    1 + 5 + 6 <= 12
    // Para n = 2    1 + 10/4 + 6/4 <= 12
    // Por lo que f(n) = n² + 5n + 6 pertenece a O(n²) para c = 12 y n0 = 1
}
