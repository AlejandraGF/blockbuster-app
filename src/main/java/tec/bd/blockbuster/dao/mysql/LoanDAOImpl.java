package tec.bd.blockbuster.dao.mysql;

import tec.bd.blockbuster.dao.CategoryDAO;
import tec.bd.blockbuster.dao.LoanDAO;
import tec.bd.blockbuster.entity.Categoria;
import tec.bd.blockbuster.entity.Prestamo;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class LoanDAOImpl  extends GenericMySqlDAOImpl<Prestamo, Long> implements LoanDAO {
    private final DataSource dataSource;

    public LoanDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Prestamo> findAll() {
        return null;
    }

    @Override
    public Optional<Prestamo> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void save(Prestamo prestamo) {

    }

    @Override
    public void update(Prestamo prestamo) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    protected Prestamo resultSetToEntity(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected List<Prestamo> resultSetToList(ResultSet resultSet) throws SQLException {
        return null;
    }
}
