package socket.TCP1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-10-23
 * Time: 14:45
 */
public class TcpClient {
    private static final String SERVER_HOST = "localhost";

    private static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        Socket client = new Socket(SERVER_HOST, PORT);

        OutputStream os = client.getOutputStream();

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "utf8"));

        pw.println("hello_world");

        pw.flush();

        client.close();

    }
}
