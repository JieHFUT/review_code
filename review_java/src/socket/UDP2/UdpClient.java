package socket.UDP2;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-10-23
 * Time: 13:59
 */
public class UdpClient {
    // 服务端Socket地址，包含域名或者IP，以及端口号
    private static final SocketAddress ADDRESS = new InetSocketAddress("localhost", 8888);

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("===================================");
            System.out.println("请输入要展示的目录：");
            String request = scanner.nextLine() + "\3";
            byte[] requestData = request.getBytes(StandardCharsets.UTF_8);

            DatagramPacket requestPacket = new DatagramPacket(requestData, requestData.length, ADDRESS);

            socket.send(requestPacket);

            // 接收
            byte[] responseData = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length);
            socket.receive(responsePacket);

            System.out.println("该目录下的文件列表为: ");
            int next = 0;
            for (int i = 0; i < responseData.length; i++) {
                byte b = requestData[i];
                if (b == '\3')
                    break;
                if (b == '\n'){
                    String fileName = new String(responseData, next, i-next);
                    System.out.println(fileName);
                    next = i + 1;
                }

            }

        }
    }
}
