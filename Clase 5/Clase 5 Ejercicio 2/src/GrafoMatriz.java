import java.util.*;

public class GrafoMatriz {
    private int[][] matrizAdyacencia;
    private int numVertices;
    private Map<String, Integer> indiceVertices;
    private Map<Integer, String> nombreVertices;

    // Inicializa el grafo con un número máximo de vértices
    public GrafoMatriz(int maxVertices) {
        this.numVertices = 0;
        this.matrizAdyacencia = new int[maxVertices][maxVertices];
        this.indiceVertices = new HashMap<>();
        this.nombreVertices = new HashMap<>();
    }

    // Método para agregar un vértice al grafo
    public void agregarVertice(String nombre) {
        if (!indiceVertices.containsKey(nombre)) {
            indiceVertices.put(nombre, numVertices);
            nombreVertices.put(numVertices, nombre);
            numVertices++;
            System.out.println("Vértice " + nombre + " agregado.");
        } else {
            System.out.println("El vértice " + nombre + " ya existe.");
        }
    }

    // Método para agregar una arista de un vértice A a B
    public void agregarArista(String origen, String destino) {
        Integer indiceOrigen = indiceVertices.get(origen);
        Integer indiceDestino = indiceVertices.get(destino);

        if (indiceOrigen == null || indiceDestino == null) {
            System.out.println("Uno o ambos vértices no existen.");
            return;
        }

        matrizAdyacencia[indiceOrigen][indiceDestino] = 1;
        System.out.println("Arista agregada de " + origen + " a " + destino);
    }

    // Método para eliminar una arista de un vértice A a B
    public void eliminarArista(String origen, String destino) {
        Integer indiceOrigen = indiceVertices.get(origen);
        Integer indiceDestino = indiceVertices.get(destino);

        if (indiceOrigen == null || indiceDestino == null) {
            System.out.println("Uno o ambos vértices no existen.");
            return;
        }

        matrizAdyacencia[indiceOrigen][indiceDestino] = 0;
        System.out.println("Arista eliminada de " + origen + " a " + destino);
    }

    // Método para verificar si existe una arista de un vértice A a B
    public boolean verificarArista(String origen, String destino) {
        Integer indiceOrigen = indiceVertices.get(origen);
        Integer indiceDestino = indiceVertices.get(destino);

        if (indiceOrigen == null || indiceDestino == null) {
            System.out.println("Uno o ambos vértices no existen.");
            return false;
        }

        return matrizAdyacencia[indiceOrigen][indiceDestino] == 1;
    }

    // Método para listar los vértices adyacentes a un vértice dado
    public void listarAdyacentes(String nombre) {
        Integer indice = indiceVertices.get(nombre);

        if (indice == null) {
            System.out.println("El vértice no existe.");
            return;
        }

        System.out.println("Vértices adyacentes a " + nombre + ":");
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdyacencia[indice][i] == 1) {
                System.out.println("- " + nombreVertices.get(i));
            }
        }
    }

    // Método para contar el grado de salida de un vértice dado
    public int contarGradoSalida(String nombre) {
        Integer indice = indiceVertices.get(nombre);

        if (indice == null) {
            System.out.println("El vértice no existe.");
            return -1;
        }

        int gradoSalida = 0;
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdyacencia[indice][i] == 1) {
                gradoSalida++;
            }
        }

        return gradoSalida;
    }

    // Método para contar el grado de entrada de un vértice dado
    public int contarGradoEntrada(String nombre) {
        Integer indice = indiceVertices.get(nombre);

        if (indice == null) {
            System.out.println("El vértice no existe.");
            return -1;
        }

        int gradoEntrada = 0;
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdyacencia[i][indice] == 1) {
                gradoEntrada++;
            }
        }

        return gradoEntrada;
    }
}
