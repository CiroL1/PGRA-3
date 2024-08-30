public class Ordenar {
    int full;
    public void Valorimetro(int tamañomax,Objeto[] objetos){
        this.full=tamañomax;
        int largo=objetos.length ;
        // inicio de super red nenuronal multiple
        if (full>0){
            int i=0;
            int total=0;
            while (full>=0){        //se restan uno en uno los elementos del array
                if (full - objetos[i].tamaño>=0){
                    full=full - objetos[i].tamaño;
                    total=total+objetos[i].valor;

                }else {
                    if (i == largo - 1) {
                        break;
                    } else {
                        i++;    //cuando ya no entra mas de un elemento se pasa al siguiente
                    }
                }

            }
            System.out.println(full);   //printea cuanto esapcio sobro
            System.out.println(total);  //printea el total de dinero


        }





    }
}
