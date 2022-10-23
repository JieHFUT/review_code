package socket.TCP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-10-23
 * Time: 14:34
 */
public class TcpServer {
    private static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);

        while (true) {
            System.out.println("=======================================");
            System.out.println("等待客户端来连接");
            Socket client = server.accept();

            System.out.printf("客户端ip：%s%n", client.getInetAddress().getHostAddress());
            System.out.printf("客户端端口：%s%n", client.getPort());

            // 获取客户端发来的数据
            InputStream is = client.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf8"));
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }


            client.close();
        }

    }
}
