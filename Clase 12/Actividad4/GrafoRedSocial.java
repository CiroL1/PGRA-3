package clase12.actividad4;

import java.util.*;

public class GrafoRedSocial {
    private final Map<Integer, Usuario> usuarios; // Almacena usuarios por su ID
    private final Map<Integer, List<Integer>> amistades; // Lista de adyacencia

    public GrafoRedSocial() {
        this.usuarios = new HashMap<>();
        this.amistades = new HashMap<>();
    }

    // agregar un usuario a la red
    public void agregarUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
        amistades.putIfAbsent(usuario.getId(), new ArrayList<>());
    }

    // conectar dos usuarios como amigos (relación bidireccional)
    public void conectarAmigos(int idUsuario1, int idUsuario2) {
        if (usuarios.containsKey(idUsuario1) && usuarios.containsKey(idUsuario2)) {
            amistades.get(idUsuario1).add(idUsuario2);
            amistades.get(idUsuario2).add(idUsuario1); // bidireccional
        } else {
            System.out.println("Uno o ambos usuarios no existen.");
        }
    }

    // recorrer la red desde un usuario dado (con DFS)
    public void recorridoDFS(int idUsuarioInicio) {
        Set<Integer> visitados = new HashSet<>();
        System.out.println("Recorrido DFS:");
        dfs(idUsuarioInicio, visitados);
    }

    private void dfs(int idUsuario, Set<Integer> visitados) {
        visitados.add(idUsuario);
        System.out.println(usuarios.get(idUsuario));

        for (int amigo : amistades.get(idUsuario)) {
            if (!visitados.contains(amigo)) {
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

        System.out.println("Recorrido BFS:");
        while (!cola.isEmpty()) {
            int idUsuario = cola.poll();
            System.out.println(usuarios.get(idUsuario));

            for (int amigo : amistades.get(idUsuario)) {
                if (!visitados.contains(amigo)) {
                    cola.add(amigo);
                    visitados.add(amigo);
                }
            }
        }
    }
}

