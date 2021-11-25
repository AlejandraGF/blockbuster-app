package tec.bd.blockbuster.cli.loan;

import picocli.CommandLine;
import tec.bd.blockbuster.ApplicationContext;
import tec.bd.blockbuster.Blockbuster;

@CommandLine.Command(name = "loand", description = "Delete Loan")
public class DeleteLoanCommand implements Runnable {



    @CommandLine.Parameters(index = "0",paramLabel = "<Client id>", description = "Client id")
    private long id;
    @CommandLine.Parameters(index = "1",paramLabel = "<Movie id>", description = "Movie id")
    private long movieId;

    @Override
    public void run() {
        Blockbuster blockbuster = new ApplicationContext().getBlockbuster();
        blockbuster.removeLoan(id,movieId);

    }
}
