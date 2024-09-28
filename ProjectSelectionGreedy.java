package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class ProjectSelectionGreedy {

    // Clase auxiliar para almacenar el costo, beneficio y la relación beneficio/costo de cada proyecto
    static class Proyecto {
        int costo, beneficio;
        double ratio;

        public Proyecto(int costo, int beneficio) {
            this.costo = costo;
            this.beneficio = beneficio;
            this.ratio = (double) beneficio / costo;
        }
    }

    // Método que calcula el beneficio máximo utilizando el enfoque voraz (greedy)
    public static int maxBenefitGreedy(int[] costos, int[] beneficios, int presupuesto) {
        int n = costos.length;
        Proyecto[] proyectos = new Proyecto[n];

        // Crear un arreglo de proyectos con su ratio beneficio/costo
        for (int i = 0; i < n; i++) {
            proyectos[i] = new Proyecto(costos[i], beneficios[i]);
        }

        // Ordenar los proyectos por su relación beneficio/costo en orden descendente
        Arrays.sort(proyectos, Comparator.comparingDouble(p -> -p.ratio));

        int beneficioTotal = 0;
        int presupuestoRestante = presupuesto;

        // Seleccionar proyectos de acuerdo al presupuesto disponible
        for (Proyecto proyecto : proyectos) {
            if (presupuestoRestante >= proyecto.costo) {
                presupuestoRestante -= proyecto.costo;
                beneficioTotal += proyecto.beneficio;
            }
        }

        return beneficioTotal;
    }

    public static void main(String[] args) {
        int[] costos = {10, 15, 20, 25};  // Costos de los proyectos
        int[] beneficios = {100, 200, 150, 300};  // Beneficios esperados
        int presupuesto = 40;  // Presupuesto disponible

        // Se calcula el beneficio máximo utilizando el enfoque greedy
        int maxBeneficio = maxBenefitGreedy(costos, beneficios, presupuesto);
        System.out.println("Beneficio máximo usando el enfoque greedy: " + maxBeneficio);
    }
    /*
    Complejidad:
    O(n log n), debido a la necesidad de ordenar los proyectos en base a su beneficio/costo.
    Este enfoque no garantiza siempre una solución óptima, pero es rápido.
    */
}

