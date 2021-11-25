package tec.bd.blockbuster.cli.movie;

import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;
import tec.bd.blockbuster.ApplicationContext;
import tec.bd.blockbuster.Blockbuster;
import tec.bd.blockbuster.entity.Movie;

import java.util.Date;
import java.util.List;

@Command(name = "movc", description = "Create Movies")
public class CreateMovieCommand implements Runnable {
    // param id
    /*@Parameters(index = "0",paramLabel = "<movie id>", description = "Id of movie")
    private long movieId;*/

    @Parameters(index = "0",paramLabel = "<movie title>", description = "Movie Title")
    private String title;

    @Parameters(index = "1",paramLabel = "<movie release date>", description = "Movie Release Dateformat yyyy-MM-dd")
    private Date releaseDate;

    @Parameters(index = "2",paramLabel = "<movie category>", description = "Movie Category")
    private long category;

    @Override
    public void run() {
        Blockbuster blockbuster = new ApplicationContext().getBlockbuster();
        blockbuster.addNewMovie(new Movie(title,releaseDate,category));

    }
}
