package tec.bd.blockbuster.dao;

import tec.bd.blockbuster.entity.Cliente;
import tec.bd.blockbuster.entity.Prestamo;

import java.util.List;

public interface LoanDAO extends GenericDAO<Prestamo, Long> {

    public List<Prestamo> findById_multiple(long id);
    public void deleteLoan(long id,long codigo);

}