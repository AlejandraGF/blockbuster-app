package tec.bd.blockbuster.dao.mysql;

import tec.bd.blockbuster.dao.CustomerDAO;
import tec.bd.blockbuster.entity.Cliente;
import tec.bd.blockbuster.entity.Movie;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


public class CustomerDAOImpl extends GenericMySqlDAOImpl<Cliente, Long> implements CustomerDAO {

    private static final String SQL_INSERT_CUSTOMER = "insert into cliente(nombre,apellido,telefono_celular,direccion) values (?, ?, ?, ?)";
    private static final String SQL_GET_CUSTOMER_BY_ID = "select cedula, nombre,apellido,telefono_celular,direccion from cliente where cedula = ?";
    private static final String SQL_GET_ALL_CUSTOMERS= "select cedula, nombre,apellido,telefono_celular,direccion from cliente";
    private static final String SQL_DELETE_CUSTOMER_BY_ID = "delete from cliente where cedula = ?";
    private static final String SQL_UPDATE_CUSTOMER = "update cliente set nombre = ?,apellido = ?, telefono_celular = ?,direccion = ? where cedula = ?";
    private final DataSource dataSource;

    public CustomerDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public List<Cliente> findAll() {
        List<Cliente> clientes = new ArrayList<>();
        Connection dbConnection = null;
        try {
            dbConnection = this.dataSource.getConnection();
            dbConnection.setAutoCommit(false);
            var stmt = dbConnection.prepareStatement(SQL_GET_ALL_CUSTOMERS);
            var resultSet = stmt.executeQuery();
            dbConnection.commit();
            return resultSetToList(resultSet);
        } catch (Exception e) {
            try {
                System.out.println(e.getMessage());
                dbConnection.rollback();
            } catch (SQLException sqlEx) {
                throw new RuntimeException(sqlEx);
            }
        }
        return clientes;
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        Connection dbConnection = null;
        try {
            dbConnection = this.dataSource.getConnection();
            dbConnection.setAutoCommit(false);
            var stmt = dbConnection.prepareStatement(SQL_GET_CUSTOMER_BY_ID);
            stmt.setLong(1, id);
            var resultSet = stmt.executeQuery();
            if(resultSet.next()) {
                dbConnection.commit();
                return Optional.of(resultSetToEntity(resultSet));
            }
        } catch (Exception e) {
            try {
                System.out.println("No existe cliente con id "+id);
                System.out.println(e.getMessage());
                dbConnection.rollback();
            } catch (SQLException sqlEx) {
                throw new RuntimeException(sqlEx);
            }
        }
        return Optional.empty();
    }

    @Override
    public void save(Cliente cliente) {
        Connection dbConnection = null;
        try {
            dbConnection = this.dataSource.getConnection();
            dbConnection.setAutoCommit(false);
            PreparedStatement stmt = dbConnection.prepareStatement(SQL_INSERT_CUSTOMER);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setLong(3, cliente.getTelefono());
            stmt.setString(4, cliente.getDireccion());
            int rows = stmt.executeUpdate();
            if (rows != 0) {
                System.out.println("Se guardo satisfactoriamente el cliente");
            }
            else{
                System.out.println("No se ha podido guardar el cliente");
            }
            dbConnection.commit();
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
    public void update(Cliente cliente) {
        Connection dbConnection = null;
        try {
            dbConnection = this.dataSource.getConnection();
            dbConnection.setAutoCommit(false);
            PreparedStatement stmt = dbConnection.prepareStatement(SQL_UPDATE_CUSTOMER);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setLong(3, cliente.getTelefono());
            stmt.setString(4, cliente.getDireccion());
            stmt.setLong(5, cliente.getCedula());

            int rows = stmt.executeUpdate();
            if (rows != 0) {
                System.out.println("Se actualizo satisfactoriamente el cliente");
            }
            else{
                System.out.println("No se ha podido actualizar el cliente");
            }
            dbConnection.commit();
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
    public void delete(Long id) {
        Connection dbConnection = null;
        try {
            dbConnection = this.dataSource.getConnection();
            dbConnection.setAutoCommit(false);
            PreparedStatement stmt = dbConnection.prepareStatement(SQL_DELETE_CUSTOMER_BY_ID);
            stmt.setLong(1, id);
            int rows = stmt.executeUpdate();
            if (rows != 0) {
                System.out.println("Se elimino satisfactoriamente el cliente");
            }
            else{
                System.out.println("No se ha podido eliminar el cliente");
            }
            dbConnection.commit();
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
    protected Cliente resultSetToEntity(ResultSet resultSet) throws SQLException {
        var cedula = resultSet.getLong("cedula");
        var nombre = resultSet.getString("nombre");
        var apellido = resultSet.getString("apellido");
        var telefono = resultSet.getLong("telefono_celular");
        var direccion = resultSet.getString("direccion");
        var cliente = new Cliente(cedula,nombre,apellido,telefono,direccion);
        return cliente;
    }

    @Override
    protected List<Cliente> resultSetToList(ResultSet resultSet) throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        while(resultSet.next()) {
            clientes.add(resultSetToEntity(resultSet));
        }
        return clientes;
    }
}
