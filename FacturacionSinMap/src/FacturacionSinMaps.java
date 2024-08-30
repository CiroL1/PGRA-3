import java.util.ArrayList;
import java.util.List;

class Cliente {
    int idCliente;
    String nombreCliente;

    public Cliente(int idCliente, String nombreCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
    }
}

class Factura {
    int idFactura;
    int idCliente;
    double importe;

    public Factura(int idFactura, int idCliente, double importe) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.importe = importe;
    }
}

class ClienteTotal {
    int idCliente;
    String nombreCliente;
    double totalImporte;

    public ClienteTotal(int idCliente, String nombreCliente, double totalImporte) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.totalImporte = totalImporte;
    }
}

public class FacturacionSinMaps {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Juan"));
        clientes.add(new Cliente(2, "María"));
        clientes.add(new Cliente(3, "Pedro"));

        List<Factura> facturas = new ArrayList<>();
        facturas.add(new Factura(1, 1, 100.0));
        facturas.add(new Factura(2, 2, 200.0));
        facturas.add(new Factura(3, 1, 150.0));
        facturas.add(new Factura(4, 3, 250.0));

        List<ClienteTotal> clienteTotales = new ArrayList<>();

        for (Cliente cliente : clientes) {
            double totalImporte = 0.0;
            for (Factura factura : facturas) {
                if (factura.idCliente == cliente.idCliente) {
                    totalImporte += factura.importe;
                }
            }
            clienteTotales.add(new ClienteTotal(cliente.idCliente, cliente.nombreCliente, totalImporte));
        }

        for (ClienteTotal clienteTotal : clienteTotales) {
            System.out.println(clienteTotal.nombreCliente + ": " + clienteTotal.totalImporte);
        }
    }
}
