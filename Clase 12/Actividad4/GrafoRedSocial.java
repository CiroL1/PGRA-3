package clase12.actividad4;

import java.util.*;

// Clase Main

public class GrafoRedSocial {
    private final Map<Integer, Usuario> usuarios;
    private final Map<Integer, List<Integer>> amistades;

    public GrafoRedSocial() {
        this.usuarios = new HashMap<>();
        this.amistades = new HashMap<>();
    }

    // agregar un usuario a la red
    public void agregarUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
        amistades.putIfAbsent(usuario.getId(), new ArrayList<>());
    }

    // conectar dos usuarios como amigos (relacion bidireccional)
    public void conectarAmigos(int idUsuario1, int idUsuario2) {
        if (usuarios.containsKey(idUsuario1) && usuarios.containsKey(idUsuario2)) {
            amistades.get(idUsuario1).add(idUsuario2);
            amistades.get(idUsuario2).add(idUsuario1); // bidireccional
            System.out.println(usuarios.get(idUsuario1).getNombre() + " y "
                    + usuarios.get(idUsuario2).getNombre() + " son amigos ahora.");
        } else {
            System.out.println("Uno o los dos usuarios no existen.");
        }
    }

    // recorrer la red desde un usuario dado (DFS)
    public void recorridoDFS(int idUsuarioInicio) {
        Set<Integer> visitados = new HashSet<>();
        System.out.println("Recorrido DFS desde " + usuarios.get(idUsuarioInicio).getNombre() + ":");
        dfs(idUsuarioInicio, visitados);
    }

    private void dfs(int idUsuario, Set<Integer> visitados) {
        visitados.add(idUsuario);
        System.out.println(usuarios.get(idUsuario));

        for (int amigo : amistades.get(idUsuario)) {
            if (!visitados.contains(amigo)) {
                System.out.println("  Amigo de " + usuarios.get(idUsuario).getNombre() + ": "
                        + usuarios.get(amigo).getNombre());
                dfs(amigo, visitados);
            }
        }
    }

    // recorrer la red desde un usuario dado (BFS)
    public void recorridoBFS(int idUsuarioInicio) {
        Set<Integer> visitados = new HashSet<>();
        Queue<Integer> cola = new LinkedList<>();
        cola.add(idUsuarioInicio);
        visitados.add(idUsuarioInicio);

        System.out.println("Recorrido BFS desde " + usuarios.get(idUsuarioInicio).getNombre() + ":");
        while (!cola.isEmpty()) {
            int idUsuario = cola.poll();
            System.out.println(usuarios.get(idUsuario));

            for (int amigo : amistades.get(idUsuario)) {
                if (!visitados.contains(amigo)) {
                    System.out.println("  Amigo de " + usuarios.get(idUsuario).getNombre() + ": "
                            + usuarios.get(amigo).getNombre());
                    cola.add(amigo);
                    visitados.add(amigo);
                }
            }
        }
    }
}
