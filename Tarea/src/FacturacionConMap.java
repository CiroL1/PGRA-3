import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacturacionConMap {
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

        Map<Integer, ClienteTotal> clienteTotalMap = new HashMap<>();

        for (Factura factura : facturas) {
            ClienteTotal clienteTotal = clienteTotalMap.get(factura.idCliente);
            if (clienteTotal == null) {
                for (Cliente cliente : clientes) {
                    if (cliente.idCliente == factura.idCliente) {
                        clienteTotal = new ClienteTotal(cliente.idCliente, cliente.nombreCliente, factura.importe);
                        clienteTotalMap.put(factura.idCliente, clienteTotal);
                        break;
                    }
                }
            } else {
                clienteTotal.totalImporte += factura.importe;
            }
        }

        for (ClienteTotal clienteTotal : clienteTotalMap.values()) {
            System.out.println(clienteTotal.nombreCliente + ": " + clienteTotal.totalImporte);
        }
    }
}
