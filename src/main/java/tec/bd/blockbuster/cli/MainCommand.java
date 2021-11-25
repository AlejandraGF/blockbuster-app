package tec.bd.blockbuster.cli;

import picocli.CommandLine.Command;
import picocli.CommandLine.HelpCommand;
import tec.bd.blockbuster.cli.category.CreateCategoryCommand;
import tec.bd.blockbuster.cli.category.DeleteCategoryCommand;
import tec.bd.blockbuster.cli.category.GetCategoryCommand;
import tec.bd.blockbuster.cli.category.UpdateCategoryCommand;
import tec.bd.blockbuster.cli.customer.CreateCustomerCommand;
import tec.bd.blockbuster.cli.customer.DeleteCustomerCommand;
import tec.bd.blockbuster.cli.customer.GetCustomersCommand;
import tec.bd.blockbuster.cli.customer.UpdateCustomerCommand;
import tec.bd.blockbuster.cli.loan.CreateLoanCommand;
import tec.bd.blockbuster.cli.loan.DeleteLoanCommand;
import tec.bd.blockbuster.cli.loan.GetLoanCommand;
import tec.bd.blockbuster.cli.movie.*;

@Command(
        name = "BlockbusterAPP",
        subcommands = {
                GetMoviesCommand.class,
                GetByTitleCommand.class,
                CreateMovieCommand.class,
                DeleteMovieCommand.class,
                UpdateMovieCommand.class,
                CreateCustomerCommand.class,
                DeleteCustomerCommand.class,
                GetCustomersCommand.class,
                UpdateCustomerCommand.class,
                CreateCategoryCommand.class,
                GetCategoryCommand.class,
                DeleteCategoryCommand.class,
                UpdateCategoryCommand.class,
                CreateLoanCommand.class,
                DeleteLoanCommand.class,
                GetLoanCommand.class,
                HelpCommand.class
        },
        description = "Manage Movies and Customers")
public class MainCommand implements Runnable {

    @Override
    public void run() {

    }
}