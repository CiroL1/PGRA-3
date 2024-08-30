
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CambioMonedas {
    public static List<Integer> Cambio(int[] monedas, double monto) {
        List<Integer> resultado = new ArrayList<>();
        if (monto< 1){
            resultado.add(1);
            System.out.println("monto menor a 1");
            return resultado;

        }
        Arrays.sort(monedas);

        for (int i = monedas.length - 1; i >= 0; i--) {
            while (monto >= monedas[i]) {
                monto -= monedas[i];
                resultado.add(monedas[i]);
            }
        }
        return resultado;}
}
