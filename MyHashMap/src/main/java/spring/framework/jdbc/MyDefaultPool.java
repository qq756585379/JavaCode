package spring.framework.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class MyDefaultPool implements IMyPool {

    // 基于多线程的考虑，这里使用了Vector。
    private Vector<MyPooledConnection> myPooledConnectionVector = new Vector<>();

    private static String jdbcUrl = "";
    private static String jdbcUserName = "";
    private static String jdbcPassword = "";
    private static int initCount = 10;
    private static int step = 2;
    private static int maxCount = 50;

    public MyDefaultPool() {
        try {
            Class.forName(DBConfigXML.jdbcDriver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //初始化数据库连接池管理
        createMyPooledConnection(initCount);
    }

    @Override
    public MyPooledConnection getMyPooledConnection() {
        if (myPooledConnectionVector.size() < 1) {
            throw new RuntimeException("连接池初始化错误！");
        }
        MyPooledConnection myPooledConnection = null;
        try {
            myPooledConnection = getMyPooledConnectionFromPool();
            while (myPooledConnection == null) {
                createMyPooledConnection(step);
                myPooledConnection = getMyPooledConnectionFromPool();
                return myPooledConnection;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myPooledConnection;
    }

    private synchronized MyPooledConnection getMyPooledConnectionFromPool() throws SQLException {
        for (MyPooledConnection myPooledConnection : myPooledConnectionVector) {
            if (!myPooledConnection.isBusy()) {
                if (myPooledConnection.getConnection().isValid(3000)) {
                    myPooledConnection.setBusy(true);
                    return myPooledConnection;
                } else {
                    Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUserName, jdbcPassword);
                    myPooledConnection.setConnection(connection);
                    myPooledConnection.setBusy(true);
                    return myPooledConnection;
                }
            }
        }
        return null;
    }

    @Override
    public void createMyPooledConnection(int count) {
        if (myPooledConnectionVector.size() > maxCount || myPooledConnectionVector.size() + count > maxCount) {
            throw new RuntimeException("连接池已满！");
        }
        for (int i = 0; i < count; i++) {
            try {
                Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUserName, jdbcPassword);
                MyPooledConnection myPooledConnection = new MyPooledConnection(connection, false);
                myPooledConnectionVector.add(myPooledConnection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
