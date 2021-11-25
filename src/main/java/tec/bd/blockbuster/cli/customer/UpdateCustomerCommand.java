package tec.bd.blockbuster.cli.customer;

import picocli.CommandLine;
import tec.bd.blockbuster.ApplicationContext;
import tec.bd.blockbuster.Blockbuster;
import tec.bd.blockbuster.entity.Cliente;

@CommandLine.Command(name = "cusu", description = "Update Customer by id")
public class UpdateCustomerCommand implements Runnable {


    @CommandLine.Parameters(index = "0",paramLabel = "<Customer´s Id>", description = "Customer´s Id")
    private long id;

    @CommandLine.Parameters(index = "1",paramLabel = "<Customer´s Name>", description = "Customer´s Name")
    private String name;

    @CommandLine.Parameters(index = "2",paramLabel = "<Customer´s LastName>", description = "Customer´s LastName")
    private String lastname;

    @CommandLine.Parameters(index = "3",paramLabel = "<Customer´s Phone number>", description = "Customer´s PhoneNumber")
    private long phoneNumber;

    @CommandLine.Parameters(index = "4",paramLabel = "<Customer´s Adress>", description = "Customer´s Adress")
    private String adress;

    @Override
    public void run() {
        Blockbuster blockbuster = new ApplicationContext().getBlockbuster();
        blockbuster.updateCustomer(new Cliente(id,name,lastname,phoneNumber,adress));

    }
}
