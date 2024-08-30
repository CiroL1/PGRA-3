public class Main {
    public static void main(String[] args) {
        double total=0;
        Moneda dolar = new Moneda(1200.3, "dolares");
        Moneda euro = new Moneda(1220.3, "euros");
        Moneda libra = new Moneda(1248.36, "libras");
        Cambio cambio=new Cambio();
        total =total +cambio.hacer(350,dolar,"cheque");
        System.out.println();
        System.out.println();
        total =total +cambio.hacer(350,euro,"billetes");
        System.out.println();
        System.out.println();
        total =total +cambio.hacer(350,libra,"transferencia");
        System.out.println();
        System.out.println();

        System.out.println("total; "+total+"  pesos");
    }
}