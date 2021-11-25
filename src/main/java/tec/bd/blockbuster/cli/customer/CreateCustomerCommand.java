package tec.bd.blockbuster.cli.customer;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import tec.bd.blockbuster.ApplicationContext;
import tec.bd.blockbuster.Blockbuster;
import tec.bd.blockbuster.entity.Cliente;
import tec.bd.blockbuster.entity.Movie;

import java.util.Date;
import java.util.List;

@Command(name = "cusc", description = "Create Customers")
//> mvn exec:java -Dexec.args="cusc 1 Juan Soto 88669977"
public class CreateCustomerCommand implements Runnable {

    @Parameters(index = "0",paramLabel = "<Customer´s Name>", description = "Customer´s Name")
    private String name;

    @Parameters(index = "1",paramLabel = "<Customer´s LastName>", description = "Customer´s LastName")
    private String lastname;

    @Parameters(index = "2",paramLabel = "<Customer´s Phone number>", description = "Customer´s PhoneNumber")
    private long phoneNumber;

    @Parameters(index = "3",paramLabel = "<Customer´s Adress>", description = "Customer´s Adress")
    private String adress;

    @Override
    public void run() {
        Blockbuster blockbuster = new ApplicationContext().getBlockbuster();
        blockbuster.addNewCustomer(new Cliente(name,lastname,phoneNumber,adress));

    }
}
