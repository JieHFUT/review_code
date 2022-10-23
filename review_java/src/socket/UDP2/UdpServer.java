package socket.UDP2;

import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-10-23
 * Time: 11:36
 */
public class UdpServer {
    // 服务器socket要绑定的端口号
    private static final int PORT = 8888;

    // 本地文件目录展示的根路径
    private static final String BASE_PATH = "E:/TMP";

    public static void main(String[] args) throws IOException {
        // 1、创建服务端DatagramSocket, 指定端口，可以发送及节后UDP数据报
        DatagramSocket socket = new DatagramSocket(PORT);

        // 2、不停的接收客户端的数据报
        while (true) {
            // 创建数据报，用于结合接收客户端发送的数据
            byte[] requestData = new byte[1024];
            DatagramPacket requestPacket = new DatagramPacket(requestData, requestData.length);
            System.out.println("==========================================================");

            System.out.println("等待接收数据报");
            socket.receive(requestPacket);

            System.out.printf("客户端   IP：%s%n",requestPacket.getAddress().getHostAddress());
            System.out.printf("客户端端口号：%s%n",requestPacket.getPort());
            System.out.printf("客户端发送的原生数据为：%s%n", Arrays.toString(requestPacket.getData()));
            System.out.printf("客户端发送的文本数据为：%s%n", new String(requestPacket.getData()));


            // 根据收到的数据报的请求来执行业务，并且返回响应
            for (int i = 0; i < requestData.length; i++) {
                byte b = requestData[i];
                if (b == '\3') {
                    // 读取请求中的数据，并且读取到约定好的结束符，取结束符之前的内容
                    String request = new String(requestData, 0, i);

                    // 执行对请求的业务流程
                    System.out.printf("客户端请求的文件列表路径为：%s%n", BASE_PATH + request);
                    File dir = new File(BASE_PATH + request);

                    // 获取下一级的子文件夹
                    File[] children = dir.listFiles();
                    // 构造要返回的响应内容，每个文件及目录名称为一行
                    StringBuilder response = new StringBuilder();
                    if (children != null){
                        for (File child:
                             children) {
                            response.append(child.getName() + "\n");
                        }
                    }
                    // 响应也要约定结束符
                    response.append("\3");
                    byte[] responseData = response.toString().getBytes(StandardCharsets.UTF_8);

                    // 构造返回响应的数据报DatagramPacket，注意接收的客户端数据报包括IP和端口号，要设置到响应的数据报中
                    DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, requestPacket.getSocketAddress());
                    // 发送
                    socket.send(responsePacket);
                    break;

                }
            }

        }

    }
}
