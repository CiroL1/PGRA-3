public class Main {
    static class Pair {
        int max1;
        int max2;

        public Pair(int max1, int max2) {
            this.max1 = max1;
            this.max2 = max2;
        }
    }

    public static Pair encontrarDosMaximos(int[] numeros, int inicio, int fin) {
        if (inicio == fin) {
            return new Pair(numeros[inicio], Integer.MIN_VALUE); // Solo un número, el segundo es mínimo
        }
        if (fin == inicio + 1) {
            if (numeros[inicio] > numeros[fin]) {
                return new Pair(numeros[inicio], numeros[fin]);
            } else {
                return new Pair(numeros[fin], numeros[inicio]);
            }
        }

        int mitad = (inicio + fin) / 2;

        Pair izquierda = encontrarDosMaximos(numeros, inicio, mitad);
        Pair derecha = encontrarDosMaximos(numeros, mitad + 1, fin);

        if (izquierda.max1 > derecha.max1) {
            int segundoMayor = Math.max(izquierda.max2, derecha.max1);
            return new Pair(izquierda.max1, segundoMayor);
        } else {
            int segundoMayor = Math.max(izquierda.max1, derecha.max2);
            return new Pair(derecha.max1, segundoMayor);
        }
    }

    public static void main(String[] args) {
        int[] numeros = {3, 5, 1, 8, 7, 2, 9, 6};

        Pair resultado = encontrarDosMaximos(numeros, 0, numeros.length - 1);

        System.out.println("El mayor número es: " + resultado.max1);
        System.out.println("El segundo mayor número es: " + resultado.max2);
    }
}
