package upload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@MultipartConfig
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("MyFile");
        // 获取到文件的真实名字.
        System.out.println(part.getSubmittedFileName());
        // 获取文件大小
        System.out.println(part.getSize());
        // 获取文件的类型.
        System.out.println(part.getContentType());
        // 把文件写入服务器这边的磁盘中.
        part.write("d:/result.jpg");

        resp.getWriter().write("upload ok");
    }
}
