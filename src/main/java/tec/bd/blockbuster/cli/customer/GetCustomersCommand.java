package tec.bd.blockbuster.cli.customer;

import picocli.CommandLine;
import tec.bd.blockbuster.ApplicationContext;
import tec.bd.blockbuster.Blockbuster;
import tec.bd.blockbuster.entity.Cliente;
import tec.bd.blockbuster.entity.Movie;

import java.util.List;

@CommandLine.Command(name = "cusr", description = "Return Customers")
public class GetCustomersCommand implements Runnable {
    @CommandLine.Parameters(paramLabel = "<Customer´s id>", description = "Customer´s id", defaultValue = "0")
    private long id;

    @Override
    public void run() {

        Blockbuster blockbuster = new ApplicationContext().getBlockbuster();

        if (id != 0) {
            // La logica encontrar por movieId
            System.out.println("=== Get Customer´s Id === ");
            Cliente cliente = blockbuster.getCustomer(id);

            System.out.println("Id: "+ cliente.getCedula()+ ", Nombre: " + cliente.getNombreCompleto()+", Telefono: "+cliente.getTelefono()+", Direccion: "+ cliente.getDireccion());

        } else {

            System.out.println("=== Get All Customers === ");

            List<Cliente> clientes = blockbuster.getAllCustomers();

            for (Cliente cliente : clientes) {
                System.out.println("Id: "+ cliente.getCedula()+ ", Nombre: " + cliente.getNombreCompleto()+", Telefono: "+cliente.getTelefono()+", Direccion: "+ cliente.getDireccion());

            }

        }
    }

}
