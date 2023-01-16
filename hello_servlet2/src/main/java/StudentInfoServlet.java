import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 此处这个类的属性的名字, 和 json 的 key 要保持一致.
// 这里的属性是 public 或者 提供 public 的 getter 方法.
class Student {
    public int classId;
    public int studentId;
}

@WebServlet("/studentInfo")
public class StudentInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 假设客户端发来的请求形如 /studentInfo?studentId=104&studentId=20
        // 就可以通过 getParameter 方法来拿到这两个 id 的值.
        resp.setContentType("text/html; charset=utf8");
        String queryString = req.getQueryString();
        System.out.println(queryString);
        String classId = req.getParameter("classId");
        String studentId = req.getParameter("studentId");
        System.out.println("classId: " + classId + " studentId: " + studentId);
        // resp.getWriter().write(queryString);
        resp.getWriter().write("classId: " + classId + " studentId: " + studentId);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // resp.setContentType("text/html; charset=utf8");
        // 获取到 body 中的参数.
        // 约定 body 使用 application/x-www-form-urlencoded 这种格式来传参.
        // 这个格式就形如 classId=104&studentId=20
        // 这个格式和 query string 相同!!! 只是数据是在 body 中~~
        // 针对这种格式, 获取到值的方式, 仍然是 getParameter !!!!

//        String classId = req.getParameter("classId");
//        String studentId = req.getParameter("studentId");
//        System.out.println("classId: " + classId + " studentId: " + studentId);
//        resp.getWriter().write("classId: " + classId + " studentId: " + studentId);

        // doGet(req, resp);


        // 从这里开始来处理 JSON 格式的请求
        ObjectMapper objectMapper = new ObjectMapper();
        // 从请求的 body 中进行读取, 并解析.
        // 使用 readValue 来把 json 字符串转成 Java 对象.
        // 第一个参数是一个 String 或者是一个 InputStream
        // 第二个参数是转换的结果对应的 Java 类对象
        Student student = objectMapper.readValue(req.getInputStream(), Student.class);
        System.out.println(student.classId + ", " + student.studentId);
        resp.getWriter().write(student.classId + ", " + student.studentId);


        // objectMapper.writeValue();
    }
}
