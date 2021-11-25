package tec.bd.blockbuster.cli.customer;

import picocli.CommandLine;
import tec.bd.blockbuster.ApplicationContext;
import tec.bd.blockbuster.Blockbuster;
import tec.bd.blockbuster.entity.Cliente;

@CommandLine.Command(name = "cusd", description = "Remove Customer by Id")
public class DeleteCustomerCommand implements Runnable {
    @CommandLine.Parameters(paramLabel = "<Customer´s id>", description = "Customer´s id")
    private long id;

    @Override
    public void run() {

        Blockbuster blockbuster = new ApplicationContext().getBlockbuster();
        blockbuster.removeCustomer(id);
    }
}
