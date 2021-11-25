package tec.bd.blockbuster.dao.mysql;

import tec.bd.blockbuster.dao.CategoryDAO;
import tec.bd.blockbuster.dao.LoanDAO;
import tec.bd.blockbuster.entity.Categoria;
import tec.bd.blockbuster.entity.Movie;
import tec.bd.blockbuster.entity.Prestamo;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class LoanDAOImpl  extends GenericMySqlDAOImpl<Prestamo, Long> implements LoanDAO {
    private static final String PROC_FIND_LOANS_BY_ID = "{call select_prestamo(?)}";
    private static final String PROC_FIND_ALL_LOANS = "{call select_all_prestamos()}";
    private static final String PROC_INSERT_LOAN = "{call insert_prestamo(?,?,?,?,?)}";
    private static final String PROC_DELETE_LOAN = "{call delete_prestamo(?,?)}";



    private final DataSource dataSource;

    public LoanDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Prestamo> findAll() {
        List<Prestamo> prestamos = new ArrayList<>();
        Connection dbConnection = null;
        try {
            dbConnection = this.dataSource.getConnection();
            dbConnection.setAutoCommit(false);
            CallableStatement stmt = dbConnection.prepareCall(PROC_FIND_ALL_LOANS);
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
        return prestamos;
    }

    @Override
    public Optional<Prestamo> findById(Long aLong) {
        return Optional.empty();
    }
    @Override
    public List<Prestamo> findById_multiple(long id) {
        List<Prestamo> prestamos = new ArrayList<>();
        Connection dbConnection = null;
        try {
            dbConnection = this.dataSource.getConnection();
            dbConnection.setAutoCommit(false);
            CallableStatement stmt = dbConnection.prepareCall(PROC_FIND_LOANS_BY_ID);
            stmt.setLong(1,id);
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
        return prestamos;


    }

    @Override
    public void deleteLoan(long id, long codigo) {
        Connection dbConnection = null;
        try {
            dbConnection = this.dataSource.getConnection();
            dbConnection.setAutoCommit(false);
            CallableStatement stmt = dbConnection.prepareCall(PROC_DELETE_LOAN);
            stmt.setLong(1, id);
            stmt.setLong(2, codigo);
            boolean rows = stmt.execute();
            dbConnection.commit();
            System.out.println("Se eliminó satisfactoriamente el prestamo");

        } catch (Exception e) {
            throw new RuntimeException("No se pudo eliminar el prestamo", e);
        }
    }

    @Override
    public void save(Prestamo prestamo) {
        Connection dbConnection = null;
        try {
            dbConnection = this.dataSource.getConnection();
            dbConnection.setAutoCommit(false);
            CallableStatement stmt = dbConnection.prepareCall(PROC_INSERT_LOAN);
            stmt.setLong(1, prestamo.getCedula());
            stmt.setLong(2, prestamo.getCodigo());
            stmt.setDate(3, new java.sql.Date(prestamo.getFechaPrestamo().getTime()));
            stmt.setDate(4, new java.sql.Date(prestamo.getFechaDevolucion().getTime()));
            String charr = String.valueOf(prestamo.getEstado());
            stmt.setString(5,charr);
            boolean rows = stmt.execute();
            dbConnection.commit();
            System.out.println("Se guardo satisfactoriamente el prestamo");

        } catch (Exception e) {
            throw new RuntimeException("No se pudo crear el prestamo", e);
        }
    }

    @Override
    public void update(Prestamo prestamo) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    protected Prestamo resultSetToEntity(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("cedula");
        long codigo = resultSet.getLong("pelicula_codigo");
        Date fechaPrestamo = resultSet.getDate("fecha_prestamo");
        Date fechaDevolucion = resultSet.getDate("fecha_devolucion");
        char estado = resultSet.getString("estado").charAt(0);
        return new Prestamo(id,codigo,fechaPrestamo,fechaDevolucion,estado);
    }

    @Override
    protected List<Prestamo> resultSetToList(ResultSet resultSet) throws SQLException {
        List<Prestamo> prestamos = new ArrayList<>();
        while(resultSet.next()) {
            prestamos.add(resultSetToEntity(resultSet));
        }
        return prestamos;
    }


}
