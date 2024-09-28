package BruteForce;

public class ProjectSelectionBruteForce {

    // Método que calcula el beneficio máximo utilizando fuerza bruta
    public static int maxBenefitBruteForce(int[] costos, int[] beneficios, int presupuesto, int n) {
        // Caso base: si no hay más proyectos o si el presupuesto es 0
        if (n == 0 || presupuesto == 0) {
            return 0;
        }

        // Si el costo del proyecto n-ésimo es mayor que el presupuesto, no se puede seleccionar
        if (costos[n - 1] > presupuesto) {
            return maxBenefitBruteForce(costos, beneficios, presupuesto, n - 1);
        } else {
            // Se consideran dos opciones: incluir o no el proyecto n-ésimo
            int incluir = beneficios[n - 1] + maxBenefitBruteForce(costos, beneficios, presupuesto - costos[n - 1], n - 1);
            int excluir = maxBenefitBruteForce(costos, beneficios, presupuesto, n - 1);
            // Retorna el máximo beneficio entre incluir y no incluir el proyecto
            return Math.max(incluir, excluir);
        }
    }

    public static void main(String[] args) {
        int[] costos = {10, 15, 20, 25};  // Costos de los proyectos
        int[] beneficios = {100, 200, 150, 300};  // Beneficios esperados
        int presupuesto = 40;  // Presupuesto disponible
        int n = costos.length;  // Número de proyectos

        // Se calcula el beneficio máximo utilizando fuerza bruta
        int maxBeneficio = maxBenefitBruteForce(costos, beneficios, presupuesto, n);
        System.out.println("Beneficio máximo usando fuerza bruta: " + maxBeneficio);
    }

    /*
    Complejidad:
    𝑂(2^𝑛), donde 𝑛 es el número de proyectos.
    Esto se debe a que para cada proyecto, se prueban dos casos: incluir o no el proyecto.
    */
}
