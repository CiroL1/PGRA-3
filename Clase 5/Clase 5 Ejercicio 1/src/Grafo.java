import java.util.*;

class Nodo {
    Usuario usuario;
    List<Nodo> adjacentes;

    public Nodo(Usuario usuario) {
        this.usuario = usuario;
        this.adjacentes = new ArrayList<>();
    }
}

public class Grafo {
    private Map<String, Nodo> nodos;

    public Grafo() {
        this.nodos = new HashMap<>();
    }

    // Método para crear un nodo
    public void crear(Usuario usuario) {
        if (!nodos.containsKey(usuario.id)) {
            nodos.put(usuario.id, new Nodo(usuario));
            System.out.println("Nodo " + usuario + " creado.");
        } else {
            System.out.println("El nodo " + usuario + " ya existe.");
        }
    }

    // Método para apuntar un nodo A a B
    public void apuntar(Usuario usuarioA, Usuario usuarioB) {
        Nodo nodoA = nodos.get(usuarioA.id);
        Nodo nodoB = nodos.get(usuarioB.id);

        if (nodoA == null || nodoB == null) {
            System.out.println("Uno o ambos nodos no existen.");
            return;
        }

        if (!nodoA.adjacentes.contains(nodoB)) {
            nodoA.adjacentes.add(nodoB);
            System.out.println("Nodo " + usuarioA + " ahora apunta a " + usuarioB);
        } else {
            System.out.println("Nodo " + usuarioA + " ya apunta a " + usuarioB);
        }
    }

    public void desapuntar (Usuario usuarioA, Usuario usuarioB) {
        Nodo nodoA = nodos.get(usuarioA.id);
        Nodo nodoB = nodos.get(usuarioB.id);

        if (nodoA == null || nodoB == null) {
            System.out.println("Uno o ambos nodos no existen.");
            return;
        }
        if (nodoA.adjacentes.contains(nodoB)) {
            nodoA.adjacentes.remove(nodoB);
            System.out.println("Nodo " + usuarioA + " ahora no apunta a " + usuarioB);
        } else {
            System.out.println("Nodo " + usuarioA + " ya apunta a " + usuarioB);
        }
    }
    public List<Usuario> listaSeguidos(Usuario usuario) {
        Nodo nodo = nodos.get(usuario.id);
        List<Usuario> seguidos = new ArrayList<>();

        if (nodo != null) {
            for (Nodo adjacente : nodo.adjacentes) {
                seguidos.add(adjacente.usuario);
            }
        }

        return seguidos;
    }
    public List<Usuario> listaSeguidores(Usuario usuario) {
        List<Usuario> seguidores = new ArrayList<>();

        for (Nodo nodo : nodos.values()) {
            for (Nodo adjacente : nodo.adjacentes) {
                if (adjacente.usuario.equals(usuario)) {
                    seguidores.add(nodo.usuario);
                }
            }
        }

        return seguidores;
    }
}
