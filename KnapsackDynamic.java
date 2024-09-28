package KnapsackDynamic;

public class KnapsackDynamic{

    // Método que calcula el valor máximo usando programación dinámica
    public static int knapsackDynamic(int[] pesos, int[] valores, int capacidad) {
        int n = pesos.length;  // Número de objetos
        // Matriz para almacenar los resultados de los subproblemas
        int[][] dp = new int[n + 1][capacidad + 1];

        // Llenamos la tabla dp[][] de forma ascendente (bottom-up)
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacidad; w++) {
                // Si no hay objetos o la capacidad es 0, el valor es 0
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (pesos[i - 1] <= w) {
                    // Si el peso del objeto i-ésimo es menor o igual a la capacidad actual,
                    // se calcula el máximo entre incluir o no incluir el objeto
                    dp[i][w] = Math.max(valores[i - 1] + dp[i - 1][w - pesos[i - 1]], dp[i - 1][w]);
                } else {
                    // Si no se puede incluir el objeto (demasiado pesado), se deja el valor anterior
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // El valor máximo está en la última celda de la tabla
        return dp[n][capacidad];
    }

    public static void main(String[] args) {
        int[] pesos = {3, 4, 2};  // Pesos de los objetos
        int[] valores = {4, 5, 3}; // Valores de los objetos
        int capacidad = 6;         // Capacidad de la mochila

        // Se llama al método de programación dinámica y se imprime el valor máximo
        int valorMaximo = knapsackDynamic(pesos, valores, capacidad);
        System.out.println("Valor máximo usando programación dinámica: " + valorMaximo);
    }
}