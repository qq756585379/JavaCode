package spring.framework.transaction;

import javax.sql.DataSource;

// 一个线程中的一个事务的多个操作，使用的是同一个Connection！
public class Test {

    public static final String jdbcDriver = "";
    public static final String jdbcUrl = "";
    public static final String jdbcUserName = "";
    public static final String jdbcPassword = "";

    public static void main(String[] args) {
        DataSource dataSource = null;
        final UserService userService = new UserService(dataSource);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    userService.action();
                }
            }).start();
        }
    }
}
