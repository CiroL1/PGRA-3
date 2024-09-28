package Dynamic;

public class InvestmentSelectionDynamic {

    // Método que calcula la ganancia máxima usando programación dinámica
    public static int maxProfitDP(int[] costos, int[] ganancias, int presupuesto) {
        int n = costos.length;
        // Crear tabla dp donde dp[i][j] representa la ganancia máxima con i paquetes y j presupuesto
        int[][] dp = new int[n + 1][presupuesto + 1];

        // Llenar la tabla
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= presupuesto; j++) {
                if (costos[i - 1] <= j) {
                    dp[i][j] = Math.max(ganancias[i - 1] + dp[i - 1][j - costos[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // La ganancia máxima está en dp[n][presupuesto]
        return dp[n][presupuesto];
    }

    public static void main(String[] args) {
        int[] costos = {12, 20, 15, 25};  // Costos de los paquetes de inversión
        int[] ganancias = {150, 200, 100, 300};  // Ganancias esperadas
        int presupuesto = 35;  // Presupuesto disponible

        // Calcula la ganancia máxima usando programación dinámica
        int maxGanancia = maxProfitDP(costos, ganancias, presupuesto);
        System.out.println("Ganancia máxima usando programación dinámica: " + maxGanancia);
    }
    /*
    Complejidad:
    O(n×P), donde n es el número de paquetes y P es el presupuesto disponible.
    Ventaja: Garantiza encontrar la solución óptima y es mucho más eficiente que la fuerza
    bruta para casos grandes.
    */
}