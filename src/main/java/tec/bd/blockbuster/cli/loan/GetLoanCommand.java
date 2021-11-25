package tec.bd.blockbuster.cli.loan;

import picocli.CommandLine;
import tec.bd.blockbuster.ApplicationContext;
import tec.bd.blockbuster.Blockbuster;
import tec.bd.blockbuster.entity.Categoria;
import tec.bd.blockbuster.entity.Prestamo;

import java.util.List;

@CommandLine.Command(name = "loanr", description = "Select Loans")
public class GetLoanCommand implements Runnable {



    @CommandLine.Parameters(paramLabel = "<Client id>", description = "lient id", defaultValue = "0")
    private long id;

    @Override
    public void run() {
        Blockbuster blockbuster = new ApplicationContext().getBlockbuster();

        if (id != 0) {
            // La logica encontrar por movieId
            System.out.println("=== Get Loans by ClientId === ");
            List<Prestamo> prestamos = blockbuster.getLoan(id);

            for (Prestamo prestamo : prestamos) {
                System.out.println("Id Cliente: " + prestamo.getCedula() + ", Codigo pelicula: " + prestamo.getCodigo()+",fecha de prestamo: "+prestamo.getFechaPrestamo()+", fecha de devolucion: "+prestamo.getFechaDevolucion()+", estado: "+prestamo.getEstado());
            }

        } else {
            List<Prestamo> prestamos = blockbuster.getAllLoans();
            System.out.println("=== Get All Loans=== ");
            for (Prestamo prestamo : prestamos) {
                System.out.println("Id Cliente: " + prestamo.getCedula() + ", Codigo pelicula: " + prestamo.getCodigo()+",fecha de prestamo: "+prestamo.getFechaPrestamo()+", fecha de devolucion: "+prestamo.getFechaDevolucion()+", estado: "+prestamo.getEstado());
            }

        }
    }
}
