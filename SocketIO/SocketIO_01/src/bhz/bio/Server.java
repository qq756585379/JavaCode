package bhz.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    final static int PROT = 8765;

    public static void main(String[] args) {

        ServerSocket server = null;

        try {
            server = new ServerSocket(PROT);
            System.out.println(" server start .. ");
            //进行阻塞，当有客户端连接的时候，这边就获取到socket
            Socket socket = server.accept();
            //启动一个线程执行客户端的任务
            new Thread(new ServerHandler(socket)).start();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            server = null;
        }
    }
}
