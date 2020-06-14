package spring.framework.transaction;

import javax.sql.DataSource;

public class UserService {

    private UserOrderDao userOrderDao;
    private UserAccountDao userAccountDao;
    private TransactionManager transactionManager;

    public UserService(DataSource dataSource) {
        userOrderDao = new UserOrderDao(dataSource);
        userAccountDao = new UserAccountDao(dataSource);
        transactionManager = new TransactionManager(dataSource);
    }

    public void action() {
        try {
            transactionManager.start();
            userAccountDao.buy();
            userOrderDao.order();
            transactionManager.close();
        } catch (Exception e) {
            e.printStackTrace();
            transactionManager.rollback();
        }
    }
}
