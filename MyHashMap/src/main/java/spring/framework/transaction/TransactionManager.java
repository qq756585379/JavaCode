package spring.framework.transaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {

    private DataSource dataSource;

    public TransactionManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private Connection getConnection() throws SQLException {
        return SingleThreadConnectionHolder.getConnection(dataSource);
    }

    //开启事物
    public void start() throws SQLException {
        Connection connection = getConnection();
        connection.setAutoCommit(false);
    }
    
    //回滚事物
    public void rollback(){
        Connection connection;
        try {
            connection = getConnection();
            connection.rollback();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //关闭事物
    public void close() throws SQLException {
        Connection connection = getConnection();
        connection.setAutoCommit(false);
        connection.close();
    }
}
