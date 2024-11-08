package clase12.actividad3;

import java.util.*;

public class Grafo {
    private final Map<Integer, Almacen> almacenes;
    private final Map<Integer, List<Integer>> adyacencias;

    public Grafo() {
        this.almacenes = new HashMap<>();
        this.adyacencias = new HashMap<>();
    }

    // Agregar un almacén al grafo
    public void agregarAlmacen(Almacen almacen) {
        almacenes.put(almacen.getId(), almacen);
        adyacencias.putIfAbsent(almacen.getId(), new ArrayList<>());
    }
