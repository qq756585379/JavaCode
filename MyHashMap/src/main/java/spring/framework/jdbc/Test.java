package spring.framework.jdbc;

import java.sql.ResultSet;

public class Test {

    private static IMyPool myPool = MyPoolFactory.getInstance();

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            MyPooledConnection myPooledConnection = myPool.getMyPooledConnection();
            ResultSet query = myPooledConnection.query("select * from user");
            try {
                while (query.next()) {
                    System.out.println(query.getString("name") + "," + query.getNString("age"));
                }
                myPooledConnection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
