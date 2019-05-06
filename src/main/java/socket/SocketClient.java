package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 请用Socket写一个客户端，并从中读出一行打印出来。
 */
public class SocketClient {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("172.16.40.207", 12345);
            BufferedReader pw = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(pw.readLine());
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void fun1() {
        // 1.构建客户端对象
        Socket socket = null;
        try {
            socket = new Socket("192.168.188.31", 9999);
            // 2.获得网络中的输出流对象
            OutputStream out = socket.getOutputStream();
        // 3.借助输出流对象向服务端写一句话
            out.write("hello server".getBytes());
            // 4.释放资源
            out.close();
            out = null;
            socket.close();
            socket = null;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
