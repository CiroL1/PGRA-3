public class Main {
    public static void main(String[] args) {
        // Número de estaciones eléctricas (vértices)
        int numEstaciones = 5;

        // Crear la red de distribución eléctrica
        RedElectrica red = new RedElectrica(numEstaciones);

        // Agregar conexiones (aristas) entre estaciones con sus respectivos costos
        red.agregarConexion(0, 1, 10);
        red.agregarConexion(0, 2, 20);
        red.agregarConexion(1, 2, 5);
        red.agregarConexion(1, 3, 15);
        red.agregarConexion(2, 3, 30);
        red.agregarConexion(3, 4, 10);
        red.agregarConexion(2, 4, 25);

        // Aplicar el algoritmo de Prim para encontrar el Árbol de Recubrimiento Mínimo
        red.aplicarPrim();
    }
}
