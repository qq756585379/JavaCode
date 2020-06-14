package spring.framework.transaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

// Connection本来线程不安全的，通过ThreadLocal这么封装一下，立刻就变成了线程的局部变量
public class SingleThreadConnectionHolder {

    private static ThreadLocal<ConnectionHolder> threadLocal = new ThreadLocal<>();

    private static ConnectionHolder getConnectionHolder() {
        ConnectionHolder connectionHolder = threadLocal.get();
        if (connectionHolder == null) {
            connectionHolder = new ConnectionHolder();
            threadLocal.set(connectionHolder);
        }
        return connectionHolder;
    }

    public static Connection getConnection(DataSource dataSource) throws SQLException {
        return getConnectionHolder().getConnectionByDataSource(dataSource);
    }
}
