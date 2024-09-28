package Dynamic;

public class ProjectSelectionDynamic {

    // Método que calcula el beneficio máximo utilizando programación dinámica
    public static int maxBenefitDP(int[] costos, int[] beneficios, int presupuesto) {
        int n = costos.length;
        // Crear una tabla dp donde dp[i][j] representa el beneficio máximo con i proyectos y j de presupuesto
        int[][] dp = new int[n + 1][presupuesto + 1];

        // Llenar la tabla de forma ascendente
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= presupuesto; j++) {
                if (costos[i - 1] <= j) {
                    dp[i][j] = Math.max(beneficios[i - 1] + dp[i - 1][j - costos[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // El beneficio máximo está en dp[n][presupuesto]
        return dp[n][presupuesto];
    }

    public static void main(String[] args) {
        int[] costos = {10, 15, 20, 25};  // Costos de los proyectos
        int[] beneficios = {100, 200, 150, 300};  // Beneficios esperados
        int presupuesto = 40;  // Presupuesto disponible

        // Se calcula el beneficio máximo utilizando programación dinámica
        int maxBeneficio = maxBenefitDP(costos, beneficios, presupuesto);
        System.out.println("Beneficio máximo usando programación dinámica: " + maxBeneficio);
    }

    /*
    Complejidad:
    O(n×P), donde n es el número de proyectos y P es el presupuesto disponible.
    Es un enfoque eficiente que garantiza una solución óptima.
    */
}

