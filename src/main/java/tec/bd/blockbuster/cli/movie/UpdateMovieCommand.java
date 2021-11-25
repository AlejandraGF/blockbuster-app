package tec.bd.blockbuster.cli.movie;

import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;
import tec.bd.blockbuster.ApplicationContext;
import tec.bd.blockbuster.entity.Movie;

import java.util.Date;

@Command(name = "movu", description = "Update Movie")
public class UpdateMovieCommand implements Runnable {

    @Parameters(index = "0",paramLabel = "<movie id>", description = "Id of movie")
    private long movieId;

    @Parameters(index = "1",paramLabel = "<movie title>", description = "Movie Title")
    private String title;

    @Parameters(index = "2",paramLabel = "<movie release date>", description = "Movie Release Dateformat yyyy-MM-dd")
    private Date releaseDate;

    @Parameters(index = "3",paramLabel = "<movie category>", description = "Movie Category")
    private long category;

    @Override
    public void run() {
        var blockbuster = new ApplicationContext().getBlockbuster();
        Movie movie = new Movie(movieId,title,releaseDate,category);

        blockbuster.updateMovie(movie);

            }

}
