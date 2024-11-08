package clase12.actividad3;

public class RedAlmacenes {
    public static void main(String[] args) {
        Grafo redAlmacenes = new Grafo();

        // Creamos almacenes
        Almacen almacen1 = new Almacen(1, "Almacen A");
        Almacen almacen2 = new Almacen(2, "Almacen B");
        Almacen almacen3 = new Almacen(3, "Almacen C");
        Almacen almacen4 = new Almacen(4, "Almacen D");

        // Agregamos almacenes al grafo
        redAlmacenes.agregarAlmacen(almacen1);
        redAlmacenes.agregarAlmacen(almacen2);
        redAlmacenes.agregarAlmacen(almacen3);
        redAlmacenes.agregarAlmacen(almacen4);

        // Conectamos los almacenes entre si
        redAlmacenes.conectarAlmacenes(1, 2);
        redAlmacenes.conectarAlmacenes(1, 3);
        redAlmacenes.conectarAlmacenes(2, 4);
        redAlmacenes.conectarAlmacenes(3, 4);

        
    }
}

