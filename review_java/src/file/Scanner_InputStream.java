package file;

import java.io.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-10-21
 * Time: 8:52
 */
public class Scanner_InputStream {
    public static void main(String[] args) throws IOException {
        try (InputStream inputStream = new FileInputStream("src/file/test.txt")){
            try (Scanner scanner = new Scanner(inputStream, "UTF-8")) {
                while (scanner.hasNext()){
                    //使用 next()则是直接读取------next则是在读取到换行符或者空格的时候停止
                    String s = scanner.next();
                    System.out.println(s);
                }
            }
        }


        // 注意，每次创建一个outputstream对象的时候就会先删除文件中原有的数据，就算不添加新的数据也会删除原有的数据
        try (OutputStream outputStream = new FileOutputStream("src/file/test.txt")){
            outputStream.write(97);
            outputStream.write('A');
            outputStream.flush();
        }


        try(OutputStream outputStream = new FileOutputStream("src/file/test.txt")){
            byte[] b = new byte[] {(byte)'G', (byte)'A',(byte)'a',(byte)'B'};
            outputStream.write(b);

            outputStream.flush();
        }

        try(OutputStream outputStream = new FileOutputStream("src/file/test.txt")){
            byte[] b = new byte[] {(byte)'G', (byte)'A',(byte)'a',(byte)'B', (byte)'F'};
            outputStream.write(b, 2, 3);//从下标为2的地方开始，长度为3（包括下标2）

            outputStream.flush();
        }

        try(OutputStream outputStream = new FileOutputStream("src/file/test.txt")){
            String s = "ds23多十";
            byte[] b = s.getBytes();
            outputStream.write(b);
            outputStream.flush();
        }

        try (OutputStream outputStream = new FileOutputStream("src/file/test.txt")){
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "utf8");
            PrintWriter printWriter = new PrintWriter(outputStreamWriter);

            // 接下来我们就可以使用 printwriter 对象来进行操作
            printWriter.println("这是一整行");
            printWriter.print("这是不分行");
            printWriter.print("这是不分行\n");
            printWriter.print("这是不分行\n");
            printWriter.print("这是不分行\n");
            printWriter.printf("%d\n", 3214+314);

            printWriter.flush();
        }



    }
}
