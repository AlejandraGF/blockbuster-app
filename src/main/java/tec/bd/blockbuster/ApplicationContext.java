package tec.bd.blockbuster;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import tec.bd.blockbuster.dao.CategoryDAO;
import tec.bd.blockbuster.dao.CustomerDAO;
import tec.bd.blockbuster.dao.LoanDAO;
import tec.bd.blockbuster.dao.MovieDAO;
import tec.bd.blockbuster.dao.inmemorylist.InMemoryMovieListDB;
import tec.bd.blockbuster.dao.mysql.CategoryDAOImpl;
import tec.bd.blockbuster.dao.mysql.CustomerDAOImpl;
import tec.bd.blockbuster.dao.mysql.LoanDAOImpl;
import tec.bd.blockbuster.dao.mysql.MovieDAOImpl;

import javax.sql.DataSource;

public class ApplicationContext {


    private Blockbuster blockbuster;


    public ApplicationContext() {

        var hikariDataSource = initHikariDataSource();
        var mysqlMovies = initMysqlMovieDAO(hikariDataSource);
        var mysqlCustomer = initMysqlCustomerDAO(hikariDataSource);
        var mysqlCategory = initMysqlCategoryDAO(hikariDataSource);
        var mysqlLoan = initMysqlLoanDAO(hikariDataSource);
        this.blockbuster = initBlockbuster(mysqlMovies,mysqlCustomer,mysqlCategory,mysqlLoan);
    }



    private static HikariDataSource initHikariDataSource() {
        HikariConfig config = new HikariConfig("/database.properties");
        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }

    public static MovieDAO initMysqlMovieDAO(DataSource dataSource) {
        return new MovieDAOImpl(dataSource);
    }
    public static CustomerDAO initMysqlCustomerDAO(DataSource dataSource) { return new CustomerDAOImpl(dataSource);}
    public static CategoryDAO initMysqlCategoryDAO(DataSource dataSource) { return new CategoryDAOImpl(dataSource);}
    public static LoanDAO initMysqlLoanDAO(DataSource dataSource) { return new LoanDAOImpl(dataSource);}




    public static MovieDAO initInMemoryListMovieDAO() {
        return new InMemoryMovieListDB();
    }

    public static Blockbuster initBlockbuster(MovieDAO movieDAO, CustomerDAO customerDAO, CategoryDAO categoryDAO, LoanDAO loanDAO) {
        return new Blockbuster(movieDAO, customerDAO, categoryDAO, loanDAO);
    }

    public Blockbuster getBlockbuster() {
        return blockbuster;
    }
}
