package tec.bd.blockbuster.cli.loan;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import tec.bd.blockbuster.ApplicationContext;
import tec.bd.blockbuster.Blockbuster;
import tec.bd.blockbuster.entity.Categoria;
import tec.bd.blockbuster.entity.Prestamo;

import java.util.Date;

@Command(name = "loanc", description = "Create Loan")
public class CreateLoanCommand implements Runnable {

    @Parameters(index = "0",paramLabel = "<Customers id>", description = "Customers id")
    private long cedula;
    @Parameters(index = "1",paramLabel = "<Movie id>", description = "Movie id")
    private long movieId;
    @Parameters(index = "2",paramLabel = "<Fecha Prestamo>", description = "Fecha Prestamo Dateformat yyyy-MM-dd")
    private Date fechaPrestamo;
    @Parameters(index = "3",paramLabel = "<Fecha Devolucion>", description = "Fecha Devolucion Dateformat yyyy-MM-dd")
    private Date fechaDevolucion;
    @Parameters(index = "4",paramLabel = "<Estado Prestamo>", description = "Estado Prestamo")
    private char estado;

    @Override
    public void run() {
        Blockbuster blockbuster = new ApplicationContext().getBlockbuster();
        blockbuster.addNewLoan(new Prestamo(cedula,movieId,fechaPrestamo,fechaDevolucion,estado));

    }
}
