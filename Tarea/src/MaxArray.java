public class MaxArray {
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 2, 4};
        System.out.println("El máximo es: " + findMax(arr));
    }
}
