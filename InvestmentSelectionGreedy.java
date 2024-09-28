package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class InvestmentSelectionGreedy {

    // Clase auxiliar para representar un paquete de inversión
    static class Paquete {
        int costo, ganancia;
        double ratio;

        public Paquete(int costo, int ganancia) {
            this.costo = costo;
            this.ganancia = ganancia;
            this.ratio = (double) ganancia / costo;  // Relación ganancia/costo
        }
    }

    // Método que calcula la ganancia máxima usando el enfoque greedy
    public static int maxProfitGreedy(int[] costos, int[] ganancias, int presupuesto) {
        int n = costos.length;
        Paquete[] paquetes = new Paquete[n];

        // Crear los paquetes con su relación ganancia/costo
        for (int i = 0; i < n; i++) {
            paquetes[i] = new Paquete(costos[i], ganancias[i]);
        }

        // Ordenar los paquetes según la relación ganancia/costo (de mayor a menor)
        Arrays.sort(paquetes, Comparator.comparingDouble(p -> -p.ratio));

        int gananciaTotal = 0;
        int presupuestoRestante = presupuesto;

        // Seleccionar los paquetes que maximicen la ganancia
        for (Paquete paquete : paquetes) {
            if (presupuestoRestante >= paquete.costo) {
                presupuestoRestante -= paquete.costo;
                gananciaTotal += paquete.ganancia;
            }
        }

        return gananciaTotal;
    }

    public static void main(String[] args) {
        int[] costos = {12, 20, 15, 25};  // Costos de los paquetes de inversión
        int[] ganancias = {150, 200, 100, 300};  // Ganancias esperadas
        int presupuesto = 35;  // Presupuesto disponible

        // Calcula la ganancia máxima usando el enfoque greedy
        int maxGanancia = maxProfitGreedy(costos, ganancias, presupuesto);
        System.out.println("Ganancia máxima usando el enfoque greedy: " + maxGanancia);
    }
    /*
    Complejidad:
    O(n log n), debido a la necesidad de ordenar los paquetes según su relación ganancia/costo.
    Ventaja: Es rápido y eficiente, pero no siempre encuentra la solución óptima, ya que depende
    de la relación ganancia/costo.
    */
}
