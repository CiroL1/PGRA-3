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

public class DosClientesScoring {
    public static Cliente[] encontrarDosMaxScoring(Cliente[] clientes, int inicio, int fin) {
        if (inicio == fin) {
            return new Cliente[]{clientes[inicio], null};
        }

        int mitad = (inicio + fin) / 2;
        Cliente[] maxIzquierda = encontrarDosMaxScoring(clientes, inicio, mitad);
        Cliente[] maxDerecha = encontrarDosMaxScoring(clientes, mitad + 1, fin);

        Cliente[] maxDos = new Cliente[2];
        maxDos[0] = (maxIzquierda[0].scoring > maxDerecha[0].scoring) ? maxIzquierda[0] : maxDerecha[0];

        if (maxIzquierda[0] == maxDos[0]) {
            maxDos[1] = (maxDerecha[0] != null && (maxIzquierda[1] == null || maxDerecha[0].scoring > maxIzquierda[1].scoring)) ? maxDerecha[0] : maxIzquierda[1];
        } else {
            maxDos[1] = (maxIzquierda[0] != null && (maxDerecha[1] == null || maxIzquierda[0].scoring > maxDerecha[1].scoring)) ? maxIzquierda[0] : maxDerecha[1];
        }

        return maxDos;
    }

    public static void main(String[] args) {
        Cliente[] clientes = {
                new Cliente(1, "Juan", 85),
                new Cliente(2, "Maria", 90),
                new Cliente(3, "Pedro", 80),
                new Cliente(4, "Ana", 95)
        };

        Cliente[] maxClientes = encontrarDosMaxScoring(clientes, 0, clientes.length - 1);

        System.out.println("Los dos clientes con el máximo scoring son:");
        System.out.println(maxClientes[0].nombre + " con puntuación de " + maxClientes[0].scoring);
        if (maxClientes[1] != null) {
            System.out.println(maxClientes[1].nombre + " con puntuación de " + maxClientes[1].scoring);
        }
    }
}

/*Complejidad algortimica:
La complejidad temporal del algoritmo es O(n).
Esto significa que el tiempo de ejecución del algoritmo es lineal en función del número de
clientes, lo cual es eficiente dado que solo realiza una cantidad constante de trabajo adicional
por cada paso recursivo y procesa cada elemento una vez.*/
