package tec.bd.blockbuster.cli;

import picocli.CommandLine.Command;
import picocli.CommandLine.HelpCommand;
import tec.bd.blockbuster.cli.category.CreateCategoryCommand;
import tec.bd.blockbuster.cli.category.GetCategoryCommand;
import tec.bd.blockbuster.cli.customer.CreateCustomerCommand;
import tec.bd.blockbuster.cli.customer.DeleteCustomerCommand;
import tec.bd.blockbuster.cli.customer.GetCustomersCommand;
import tec.bd.blockbuster.cli.customer.UpdateCustomerCommand;
import tec.bd.blockbuster.cli.movie.*;

@Command(
        name = "BlockbusterAPP",
        subcommands = {
                GetMoviesCommand.class,
                GetByTitleCommand.class,
                CreateMovieCommand.class,
                DeleteMovieCommand.class,
                UpdateMovieCommand.class,
                /*CreateCustomerCommand.class,
                DeleteCustomerCommand.class,
                GetCustomersCommand.class,
                UpdateCustomerCommand.class,*/
                CreateCategoryCommand.class,
                GetCategoryCommand.class,
                HelpCommand.class
        },
        description = "Manage Movies and Customers")
public class MainCommand implements Runnable {

    @Override
    public void run() {

    }
}