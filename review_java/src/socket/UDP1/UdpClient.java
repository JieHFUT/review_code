package socket.UDP1;

import java.io.IOException;
import java.net.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-10-21
 * Time: 20:40
 */
public class UdpClient {

    // 服务器socket的地址，包含域名或者IP，端口号
    private static final SocketAddress ADDRESS = new InetSocketAddress("localhost", 8888);

    public static void main(String[] args) throws IOException {
        // 创建客户端DatagramSocket， 开启随机端口就行，可以发送及接收UDP数据报
        DatagramSocket socket = new DatagramSocket();

        // 准备要发送的数据
        byte[] bytes = "hello socket".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, ADDRESS);

        // 发送UDP数据报
        socket.send(packet);
    }
}
