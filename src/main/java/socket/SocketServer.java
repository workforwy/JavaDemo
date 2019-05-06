package socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        Socket client = null;
        System.out.println("服务器已经启动");

        byte[] by = new byte[1024];
        int len = 0;
        while (true) {
            client = server.accept();
            System.out.println(client + "链接成功");

            InputStream in = client.getInputStream();
            len = in.read(by);
            System.out.println(new String(by, 0, len));
        }
    }
}
