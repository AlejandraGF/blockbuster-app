package tec.bd.blockbuster.dao.mysql;

import tec.bd.blockbuster.dao.CategoryDAO;
import tec.bd.blockbuster.entity.Categoria;
import tec.bd.blockbuster.entity.Movie;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import java.sql.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class CategoryDAOImpl extends GenericMySqlDAOImpl<Categoria, Long> implements CategoryDAO {
    private final DataSource dataSource;

    private static final String PROC_CREATE_CATEGORY = "{call insert_categoria(?)}";
    private static final String PROC_GET_ALL_CATEGORIES = "{call select_all_categorias()}";

    public CategoryDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Categoria> findAll() {
        List<Categoria> categorias = new ArrayList<>();
        Connection dbConnection = null;
        try {
            dbConnection = this.dataSource.getConnection();
            CallableStatement stmt = dbConnection.prepareCall(PROC_GET_ALL_CATEGORIES);
            var resultSet = stmt.executeQuery();
            return resultSetToList(resultSet);
        } catch (Exception e) {
        throw new RuntimeException(e);
         }
    }

    @Override
    public Optional<Categoria> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void save(Categoria categoria) {
        Connection dbConnection = null;
        try {
            dbConnection = this.dataSource.getConnection();
            CallableStatement stmt = dbConnection.prepareCall(PROC_CREATE_CATEGORY);
            stmt.setString(1, categoria.getNombre());
            boolean rows = stmt.execute();
            System.out.println("Se guardo satisfactoriamente la pelicula");

        } catch (Exception e) {
            throw new RuntimeException("No se pudo crear la categoria" + categoria.getNombre(), e);
        }
    }

    @Override
    public void update(Categoria categoria) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    protected Categoria resultSetToEntity(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre_categoria");
        return new Categoria(id,nombre);
    }

    @Override
    protected List<Categoria> resultSetToList(ResultSet resultSet) throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        while(resultSet.next()) {
            categorias.add(resultSetToEntity(resultSet));
        }
        return categorias;
    }
}
