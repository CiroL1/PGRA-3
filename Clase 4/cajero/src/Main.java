import java.util.List;
public class Main {
    public static void main(String[] args) {
        CambioMonedas cambio=new CambioMonedas();   //iniciamos el metodo que calcula el cambio
        int[] monedas = {1, 5, 10, 25};
        double monto = 30;
        List<Integer> resultado= cambio.Cambio(monedas,monto);
        System.out.println("Monedas usadas para hacer " + monto + ": " + resultado);

        System.out.println();
        System.out.println();

        monto = 0.5;
        resultado= cambio.Cambio(monedas,monto);
        System.out.println("Monedas usadas para hacer " + monto + ": " + resultado);
    }
}
