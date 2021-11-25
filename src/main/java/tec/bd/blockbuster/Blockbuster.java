package tec.bd.blockbuster;

import tec.bd.blockbuster.dao.CategoryDAO;
import tec.bd.blockbuster.dao.MovieDAO;
import tec.bd.blockbuster.dao.CustomerDAO;
import tec.bd.blockbuster.dao.LoanDAO;
import tec.bd.blockbuster.entity.Categoria;
import tec.bd.blockbuster.entity.Cliente;
import tec.bd.blockbuster.entity.Movie;
import tec.bd.blockbuster.entity.Prestamo;

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
    public List<Cliente> getAllCustomers(){return this.customerDAO.findAll();}
    public List<Prestamo> getAllLoans(){return this.loanDAO.findAll();}

    /**
     * Agrega una pelicula
     * @param movie
     */
    public void addNewMovie(Movie movie) {
        this.movieDAO.save(movie);
    }
    public void addNewCustomer(Cliente cliente){this.customerDAO.save(cliente);}
    public void addNewCategory(Categoria categoria){this.categoryDAO.save(categoria);}
    public void addNewLoan(Prestamo prestamo){this.loanDAO.save(prestamo);}


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
    public Cliente getCustomer(long id){return this.customerDAO.findById(id).orElse(null);}
    public Categoria getCategory(long id){return this.categoryDAO.findById(id).orElse(null);}
    public List<Prestamo> getLoan(long id){return this.loanDAO.findById_multiple(id);}

    public void editMovieTitle(String currentMovieName, String newMovieName) {
        var movie = this.getMovie(currentMovieName);
        movie.setTitle(newMovieName);
    }

    /**
     * Borra una pelicula
     * @param movieId
     */
    public void removeMovie(long movieId) {this.movieDAO.delete(movieId);}
    public void removeCustomer(long id){this.customerDAO.delete(id);}
    public void removeCategory(long id){this.categoryDAO.delete(id);}
    public void removeLoan(long id,long codigo){this.loanDAO.deleteLoan(id,codigo);}

    public void updateMovie(Movie movie){this.movieDAO.update(movie);}
    public void updateCustomer(Cliente cliente){this.customerDAO.update(cliente);}
    public void updateCategory(Categoria categoria){this.categoryDAO.update(categoria);}

}
