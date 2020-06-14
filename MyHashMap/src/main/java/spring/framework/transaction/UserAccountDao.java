package spring.framework.transaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class UserAccountDao {

    private DataSource dataSource;

    public UserAccountDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void buy() throws SQLException {
        Connection connection = SingleThreadConnectionHolder.getConnection(dataSource);
        //进行业务操作
        System.out.println("当前线程:" + Thread.currentThread().getName() + ",使用管道" + connection.hashCode());
    }
}
