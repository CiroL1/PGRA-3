package BruteForce;

public class InvestmentSelectionBruteForce {

    // Método que calcula la ganancia máxima utilizando fuerza bruta
    public static int maxProfitBruteForce(int[] costos, int[] ganancias, int presupuesto, int n) {
        // Caso base: sin presupuesto o sin más paquetes disponibles
        if (n == 0 || presupuesto == 0) {
            return 0;
        }

        // Si el costo del paquete actual excede el presupuesto, no se puede seleccionar
        if (costos[n - 1] > presupuesto) {
            return maxProfitBruteForce(costos, ganancias, presupuesto, n - 1);
        } else {
            // Opción 1: incluir el paquete
            int incluir = ganancias[n - 1] + maxProfitBruteForce(costos, ganancias, presupuesto - costos[n - 1], n - 1);
            // Opción 2: no incluir el paquete
            int excluir = maxProfitBruteForce(costos, ganancias, presupuesto, n - 1);
            // Retorna la máxima ganancia entre incluir o no el paquete
            return Math.max(incluir, excluir);
        }
    }

    public static void main(String[] args) {
        int[] costos = {12, 20, 15, 25};  // Costos de los paquetes de inversión
        int[] ganancias = {150, 200, 100, 300};  // Ganancias esperadas
        int presupuesto = 35;  // Presupuesto disponible
        int n = costos.length;  // Número de paquetes

        // Calcula la ganancia máxima usando fuerza bruta
        int maxGanancia = maxProfitBruteForce(costos, ganancias, presupuesto, n);
        System.out.println("Ganancia máxima usando fuerza bruta: " + maxGanancia);
    }
    /*
    Complejidad:
    O(2^n), donde n es el número de paquetes.
    Esto se debe a que para cada paquete, se consideran dos opciones: incluir o no el paquete.
    Ventaja: Garantiza encontrar la solución óptima, pero su tiempo de ejecución crece exponencialmente.
    */
}
