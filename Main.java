class Cliente {
    int id;
    String nombre;
    int scoring;

    public Cliente(int id, String nombre, int scoring) {
        this.id = id;
        this.nombre = nombre;
        this.scoring = scoring;
    }
}
public class Main {
    public static Cliente encontrarMaxScoring(Cliente[] clientes, int inicio, int fin) {
        if (inicio == fin) {
            return clientes[inicio];
        }
        int mitad = (inicio + fin) / 2;

        Cliente maxIzquierda = encontrarMaxScoring(clientes, inicio, mitad);
        Cliente maxDerecha = encontrarMaxScoring(clientes, mitad + 1, fin);

        return (maxIzquierda.scoring > maxDerecha.scoring) ? maxIzquierda : maxDerecha;
    }


    public static void main(String[] args) {
        Cliente[] clientes = {
                new Cliente(1, "Juan", 85),
                new Cliente(2, "Maria", 90),
                new Cliente(3, "Pedro", 80),
                new Cliente(4, "Ana", 95)
        };

        Cliente maxCliente = encontrarMaxScoring(clientes, 0, clientes.length - 1);

        System.out.println("Cliente con el máximo scoring: " + maxCliente.nombre + " con puntuación de " + maxCliente.scoring);
    }
}



