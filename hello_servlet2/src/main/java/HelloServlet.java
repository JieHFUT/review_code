import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // resp.setCharacterEncoding("utf8");

        // 把自动生成的调用父类的方法, 一定要删掉, 否则会有问题~~
        // super.doGet(req, resp);

        // 当前只需要写一个 hello world!!
        // 这个打印是打印在服务器的控制台上.
        System.out.println("hello java");
        // 这个打印是打印在响应报文中, 显示到页面上.
        // 就是把 "hello world" 字符串作为响应报文的 body 了. 浏览器就会把这个 body 显示到页面中了.
        resp.getWriter().write("你好世界");
        resp.setContentType("text/html; charset=utf8");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
        resp.getWriter().write("doPost22222222");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPut");
        resp.getWriter().write("doPut");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doDelete");
        resp.getWriter().write("doDelete");
    }
}
