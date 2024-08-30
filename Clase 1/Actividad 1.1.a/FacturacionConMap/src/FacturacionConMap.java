import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacturacionConMap {

    public static void main(String[] args) {
        // Inicializar datos de clientes
        List<Cliente> clientes = List.of(
                new Cliente(1, "Juan"),
                new Cliente(2, "María"),
                new Cliente(3, "Pedro")
        );
        // Inicializar datos de facturas
        List<Factura> facturas = List.of(
                new Factura(1, 1, 100.0),
                new Factura(2, 2, 200.0),
                new Factura(3, 1, 150.0),
                new Factura(4, 3, 250.0)
        );

        Map<Integer, ClienteTotal> clienteTotalMap = new HashMap<>();

        for (Factura factura : facturas) {
            ClienteTotal clienteTotal = clienteTotalMap.get(factura.idCliente);
            if (clienteTotal == null) {
                Cliente cliente = clientes.stream()
                        .filter(c -> c.idCliente == factura.idCliente)
                        .findFirst()
                        .orElse(null);
                if (cliente != null) {
                    clienteTotal = new ClienteTotal(cliente.idCliente, cliente.nombreCliente, factura.importe);
                    clienteTotalMap.put(factura.idCliente, clienteTotal);
                }
            } else {
                clienteTotal.totalImporte += factura.importe;
            }
        }

        // Imprimir el total de facturación por cliente
        clienteTotalMap.values().forEach(clienteTotal ->
                System.out.println(clienteTotal.nombreCliente + ": " + clienteTotal.totalImporte)
        );
    }
}
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
