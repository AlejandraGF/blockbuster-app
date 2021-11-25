package tec.bd.blockbuster;

import tec.bd.blockbuster.dao.CategoryDAO;
import tec.bd.blockbuster.dao.MovieDAO;
import tec.bd.blockbuster.dao.CustomerDAO;
import tec.bd.blockbuster.dao.LoanDAO;
import tec.bd.blockbuster.entity.Categoria;
import tec.bd.blockbuster.entity.Cliente;
import tec.bd.blockbuster.entity.Movie;

import java.util.List;

public class Blockbuster {

    private MovieDAO movieDAO;
    private CustomerDAO customerDAO;
    private CategoryDAO categoryDAO;
    private LoanDAO loanDAO;

    public Blockbuster(MovieDAO movieDAO, CustomerDAO customerDAO, CategoryDAO categoryDAO, LoanDAO loanDAO) {
        this.movieDAO = movieDAO;
        this.customerDAO = customerDAO;
        this.categoryDAO = categoryDAO;
        this.loanDAO = loanDAO;
    }

    /**
     * Lista todas las peliculas
     * @return
     */
    public List<Movie> getAllMovies() {
        return this.movieDAO.findAll();
    }
    public List<Categoria> getAllCategories(){return this.categoryDAO.findAll();}

    /**
     * Agrega una pelicula
     * @param movie
     */
    public void addNewMovie(Movie movie) {
        this.movieDAO.save(movie);
    }
    public void addNewCustomer(Cliente cliente){this.customerDAO.save(cliente);}
    public void addNewCategory(Categoria categoria){this.categoryDAO.save(categoria);}

    /**
     * Obtiene una pelicula por titulo
     * @param movieName
     * @return
     */
    public Movie getMovie(String movieName) {
        return this.movieDAO.findByTitle(movieName).orElse(null);
    }

    /**
     * Obtiene una pelicula por movieId
     * @param movieId
     * @return
     */
    public Movie getMovie(long movieId) {
        return this.movieDAO.findById(movieId).orElse(null);
    }

    public void editMovieTitle(String currentMovieName, String newMovieName) {
        var movie = this.getMovie(currentMovieName);
        movie.setTitle(newMovieName);
    }

    /**
     * Borra una pelicula
     * @param movieId
     */
    public void removeMovie(long movieId) {
        this.movieDAO.delete(movieId);
    }

    public void updateMovie(Movie movie){
        this.movieDAO.update(movie);
    }

}
