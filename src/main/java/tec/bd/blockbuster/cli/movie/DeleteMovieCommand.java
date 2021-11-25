package tec.bd.blockbuster.cli.movie;

import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;
import tec.bd.blockbuster.ApplicationContext;

@Command(name = "movd", description = "Delete Movie")
public class DeleteMovieCommand implements Runnable {

    @Parameters(paramLabel = "<movie id>", description = "Id of movie")
    private long movieId;

    @Override
    public void run() {
        var blockbuster = new ApplicationContext().getBlockbuster();

        blockbuster.removeMovie(movieId);

         }
}
