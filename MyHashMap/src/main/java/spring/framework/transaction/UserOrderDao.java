package spring.framework.transaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class UserOrderDao {

    private DataSource dataSource;

    public UserOrderDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public void order() throws SQLException {
        Connection connection = SingleThreadConnectionHolder.getConnection(dataSource);
        //进行业务操作
        System.out.println("当前订单线程:" + Thread.currentThread().getName() + ",使用管道" + connection.hashCode());
    }
}
