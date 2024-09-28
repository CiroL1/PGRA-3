package KnapsackBruteForce;

public class KnapsackBruteForce {

    // Método que calcula el valor máximo usando fuerza bruta
    public static int knapsackBruteForce(int[] pesos, int[] valores, int capacidad, int n) {
        // Caso base: si no hay más objetos o si la capacidad es 0
        if (n == 0 || capacidad == 0) {
            return 0; // No se puede obtener valor adicional
        }

        // Si el peso del objeto n es mayor que la capacidad restante, no se incluye
        if (pesos[n - 1] > capacidad) {
            return knapsackBruteForce(pesos, valores, capacidad, n - 1);
        } else {
            // Se comparan dos casos:
            // 1. Incluir el objeto n
            int incluir = valores[n - 1] + knapsackBruteForce(pesos, valores, capacidad - pesos[n - 1], n - 1);
            // 2. No incluir el objeto n
            int excluir = knapsackBruteForce(pesos, valores, capacidad, n - 1);
            // Se devuelve el máximo entre incluir y no incluir el objeto
            return Math.max(incluir, excluir);
        }
    }

    public static void main(String[] args) {
        int[] pesos = {3, 4, 2};  // Pesos de los objetos
        int[] valores = {4, 5, 3}; // Valores de los objetos
        int capacidad = 6;         // Capacidad de la mochila
        int n = pesos.length;      // Número de objetos

        // Se llama al método de fuerza bruta y se imprime el valor máximo
        int valorMaximo = knapsackBruteForce(pesos, valores, capacidad, n);
        System.out.println("Valor máximo usando fuerza bruta: " + valorMaximo);
    }
}
