package clase12.actividad4;

// Clase Main

public class AppRedSocial {
    public static void main(String[] args) {
        GrafoRedSocial redSocial = new GrafoRedSocial();

        // crear usuarios
        Usuario usuario1 = new Usuario(1, "Ciro");
        Usuario usuario2 = new Usuario(2, "Marcos");
        Usuario usuario3 = new Usuario(3, "Valen");
        Usuario usuario4 = new Usuario(4, "Agus");

        // agregar usuarios a la red
        redSocial.agregarUsuario(usuario1);
        redSocial.agregarUsuario(usuario2);
        redSocial.agregarUsuario(usuario3);
        redSocial.agregarUsuario(usuario4);

        // conectar usuarios como amigos
        redSocial.conectarAmigos(1, 2);
        redSocial.conectarAmigos(1, 3);
        redSocial.conectarAmigos(2, 4);
        redSocial.conectarAmigos(3, 4);

        // realizar un recorrido DFS desde el usuario 1 (Ciro)
        redSocial.recorridoDFS(1);

        System.out.println();

        // realizar un recorrido BFS desde el usuario 1 (Ciro)
        redSocial.recorridoBFS(1);
    }
}

