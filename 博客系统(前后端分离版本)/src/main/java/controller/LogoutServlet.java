package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 注销要做的是删除用户的会话信息. 因此就得先确认用户有没有会话.
        // req 对象没有直接提供一个 删除会话 的操作~~
        // 删除会话有个办法, 就是把过期时间设置成 0. 比较麻烦.
        // 更简单的办法, 虽然保留会话对象, 但是把会话里的 user 给删了.
        HttpSession session = req.getSession(false);
        if (session == null) {
            // resp.setStatus(403);
            resp.sendRedirect("login.html");
            return;
        }
        session.removeAttribute("user");
        resp.sendRedirect("login.html");
    }
}
