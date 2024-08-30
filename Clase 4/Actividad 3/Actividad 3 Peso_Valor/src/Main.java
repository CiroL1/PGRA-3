public class Main {     //(-)_(-)
    public static void main(String[] args) {
        int cant=0;
        Objeto obj1=new Objeto(10,13);
        Objeto obj2=new Objeto(6,2);
        Objeto obj3=new Objeto(3,5);
        Objeto[] objetos=new Objeto[3];
        objetos[0]=obj1;
        objetos[1]=obj2;
        objetos[2]=obj3;
        //ya esta el array con objetos preparados y ordenados de mayor valor a menor
        Ordenar ordenar=new Ordenar();
        ordenar.Valorimetro(34,objetos);
    }
}
