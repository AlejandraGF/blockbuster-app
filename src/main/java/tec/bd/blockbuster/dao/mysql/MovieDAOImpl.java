package tec.bd.blockbuster.dao.mysql;

import tec.bd.blockbuster.dao.MovieDAO;
import tec.bd.blockbuster.entity.Movie;

import javax.sql.DataSource;
import java.sql.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class MovieDAOImpl extends GenericMySqlDAOImpl<Movie, Long> implements MovieDAO {

    private static final String SQL_FIND_ALL_MOVIES = "select codigo, titulo, fecha_lanzamiento, categoria from pelicula";
    private static final String SQL_FIND_BY_ID_MOVIE = "select codigo, titulo, fecha_lanzamiento, categoria from pelicula where codigo = ?";
    private static final String SQL_FIND_BY_TITLE = "select codigo, titulo, fecha_lanzamiento, categoria from pelicula where titulo like ?";
    private static final String SQL_INSERT_MOVIE = "insert into pelicula(titulo, fecha_lanzamiento, categoria) values (?, ?, ?)";
    private static final String SQL_DELETE_MOVIE = "delete from pelicula where codigo = ?";
    private static final String SQL_UPDATE_MOVIE = "update pelicula set titulo = ?,fecha_lanzamiento = ?, categoria = ? where codigo = ?";

    private final DataSource dataSource;

    public MovieDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Movie> findAll() {
        List<Movie> movies = new ArrayList<>();
        Connection dbConnection = null;
        try {
            dbConnection = this.dataSource.getConnection();
            var stmt = dbConnection.prepareStatement(SQL_FIND_ALL_MOVIES);
            var resultSet = stmt.executeQuery();
            return resultSetToList(resultSet);
        } catch (Exception e) {
            try {
                System.out.println(e.getMessage());
                dbConnection.rollback();
            } catch (SQLException sqlEx) {
                throw new RuntimeException(sqlEx);
            }
        }
        return movies;
    }

    @Override
    public Optional<Movie> findById(Long movieId) {
        Connection dbConnection = null;
        try {
            dbConnection = this.dataSource.getConnection();
            var stmt = dbConnection.prepareStatement(SQL_FIND_BY_ID_MOVIE);
            stmt.setLong(1, movieId);
            var resultSet = stmt.executeQuery();
            if(resultSet.next()) {
                return Optional.of(resultSetToEntity(resultSet));
            }
        } catch (Exception e) {
            try {
                System.out.println("No existe pelicula con id "+movieId);
                System.out.println(e.getMessage());
                dbConnection.rollback();
            } catch (SQLException sqlEx) {
                throw new RuntimeException(sqlEx);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Movie> findByTitle(String title) {
        Connection dbConnection = null;
        try {
            dbConnection = this.dataSource.getConnection();
            var stmt = dbConnection.prepareStatement(SQL_FIND_BY_TITLE);
            stmt.setString(1, title );
            var resultSet = stmt.executeQuery();
            if(resultSet.next()) {
                return Optional.of(resultSetToEntity(resultSet));
            }
        } catch (Exception e) {
            try {
                System.out.println(e.getMessage());
                dbConnection.rollback();
            } catch (SQLException sqlEx) {
                throw new RuntimeException(sqlEx);
            }
        }
        return Optional.empty();
    }

    @Override
    public void save(Movie movie) {
        Connection dbConnection = null;
        try {
            dbConnection = this.dataSource.getConnection();
            PreparedStatement insertMovie = dbConnection.prepareStatement(SQL_INSERT_MOVIE);
            insertMovie.setString(1, movie.getTitle());
            var releaseDate = new java.sql.Date(movie.getReleaseDate().getTime());
            insertMovie.setDate(2, releaseDate);
            insertMovie.setLong(3, movie.getCategory());
            int rows = insertMovie.executeUpdate();
            if (rows != 0) {
                System.out.println("Se guardo satisfactoriamente la pelicula");
            }
            else{
                System.out.println("No se ha podido guardar la pelicula");
            }
        } catch (Exception e) {
            try {
                System.out.println(e.getMessage());
                dbConnection.rollback();
            } catch (SQLException sqlEx) {
                throw new RuntimeException(sqlEx);
            }
        }
    }

    @Override
    public void delete(Long movieId) {
        Connection dbConnection = null;
        try {
            dbConnection = this.dataSource.getConnection();
            PreparedStatement stmt = dbConnection.prepareStatement(SQL_DELETE_MOVIE);
            stmt.setLong(1, movieId);
            int rows = stmt.executeUpdate();
            if (rows != 0) {
                System.out.println("Se elimino satisfactoriamente la pelicula");
            }
            else{
                System.out.println("No se ha podido eliminar la pelicula");
            }
        } catch (Exception e) {
            try {
                System.out.println(e.getMessage());
                dbConnection.rollback();
            } catch (SQLException sqlEx) {
                throw new RuntimeException(sqlEx);
            }
        }
    }

    @Override
    public void update(Movie movie) {
        Connection dbConnection = null;
        try {
            dbConnection = this.dataSource.getConnection();
            PreparedStatement stmt = dbConnection.prepareStatement(SQL_UPDATE_MOVIE);
            stmt.setString(1, movie.getTitle());
            var releaseDate = new java.sql.Date(movie.getReleaseDate().getTime());
            stmt.setDate(2, releaseDate);
            stmt.setLong(3, movie.getCategory());
            stmt.setLong(4,movie.getMovieId());
            int rows = stmt.executeUpdate();
            if (rows != 0) {
                System.out.println("Se actualizo satisfactoriamente la pelicula");
            }
            else{
                System.out.println("No se ha podido actualizar la pelicula");
            }
        } catch (Exception e) {
            try {
                System.out.println(e.getMessage());
                dbConnection.rollback();
            } catch (SQLException sqlEx) {
                throw new RuntimeException(sqlEx);
            }
        }
    }

    @Override
    protected Movie resultSetToEntity(ResultSet resultSet) throws SQLException {
        var movieId = resultSet.getInt("codigo");
        var title = resultSet.getString("titulo");
        var releaseDate = resultSet.getDate("fecha_lanzamiento");
        var category = resultSet.getLong("categoria");
        var movie = new Movie(movieId, title, new Date(releaseDate.getTime()), category);
        return movie;
    }

    @Override
    protected List<Movie> resultSetToList(ResultSet resultSet) throws SQLException {
        List<Movie> movies = new ArrayList<>();
        while(resultSet.next()) {
            movies.add(resultSetToEntity(resultSet));
        }
        return movies;
    }
}
