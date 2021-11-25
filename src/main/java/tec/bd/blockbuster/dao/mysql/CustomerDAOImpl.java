package tec.bd.blockbuster.dao.mysql;

import tec.bd.blockbuster.dao.CustomerDAO;
import tec.bd.blockbuster.entity.Cliente;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/*> mvn exec:java -Dexec.args="cusc [params]"
> mvn exec:java -Dexec.args="cusc 1 Juan Soto 88669977"
> mvn exec:java -Dexec.args=”cusr” // retorna todos los clientes
> mvn exec:java -Dexec.args="cusr 1" // retorna cliente con ID 1
> mvn exec:java -Dexec.args="cusd 1" // borra cliente con ID 1
> mvn exec:java -Dexec.args="cusu 1 Juan Soto 33445533" // actualiza el registro en el ID
1. La llave primaria NO se puede actualizar*/
public class CustomerDAOImpl extends GenericMySqlDAOImpl<Cliente, Long> implements CustomerDAO {


    private final DataSource dataSource;

    public CustomerDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public List<Cliente> findAll() {
        return null;
    }

    @Override
    public Optional<Cliente> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void save(Cliente cliente) {

    }

    @Override
    public void update(Cliente cliente) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    protected Cliente resultSetToEntity(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected List<Cliente> resultSetToList(ResultSet resultSet) throws SQLException {
        return null;
    }
}
