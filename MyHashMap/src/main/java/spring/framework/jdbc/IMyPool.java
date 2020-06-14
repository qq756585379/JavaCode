package spring.framework.jdbc;

public interface IMyPool {

    MyPooledConnection getMyPooledConnection();

    void createMyPooledConnection(int count);
}
