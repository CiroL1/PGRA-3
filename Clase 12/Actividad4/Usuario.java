package clase12.actividad4;


public class Usuario {
    private final int id;
    private final String nombre;

    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return nombre + " (ID: " + id + ")";
    }
}

