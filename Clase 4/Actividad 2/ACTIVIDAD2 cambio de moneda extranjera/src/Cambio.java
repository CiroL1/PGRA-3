public class Cambio {
    private double resultado=0;



    public double hacer(float pesos,Moneda moneda,String forma) { //transforma la moneda exttranjera a pesos
        double resultado= pesos*(moneda.precio);
        System.out.println("se obtuvieron "+resultado+ " pesos por una "+forma+" en "+moneda.nombre);
        return resultado;
    }
}
