import java.util.List;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        Usuario usuarioA = new Usuario("1", "Jose");
        Usuario usuarioB = new Usuario("2", "Jorge");
        Usuario usuarioC = new Usuario("3", "Juan");
        Usuario usuarioD = new Usuario("4", "Javier");

        grafo.crear(usuarioA);
        grafo.crear(usuarioB);
        grafo.crear(usuarioC);
        grafo.crear(usuarioD);

        grafo.apuntar(usuarioA, usuarioB);
        grafo.apuntar(usuarioA, usuarioC);
        grafo.apuntar(usuarioB, usuarioD);

        List<Usuario> seguidosPorAlice = grafo.listaSeguidos(usuarioA);
        System.out.println("\nUsuarios que sigue Jose:");
        for (Usuario u : seguidosPorAlice) {
            System.out.println(u);
        }

        List<Usuario> seguidoresDeBob = grafo.listaSeguidores(usuarioB);
        System.out.println("\nUsuarios que siguen a Jorge:");
        for (Usuario u : seguidoresDeBob) {
            System.out.println(u);
        }

    }
}
