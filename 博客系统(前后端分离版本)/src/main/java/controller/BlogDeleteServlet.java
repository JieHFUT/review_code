package controller;

import model.BlogDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/blogDelete")
public class BlogDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 先判定用户的登录状态, 如果用户未登录, 就不给删除
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.setStatus(403);
            return;
        }
        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.setStatus(403);
            return;
        }
        // 2. 获取到 blogId
        String blogId = req.getParameter("blogId");
        if (blogId == null || blogId.equals("")) {
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("要删除的文章不存在!!");
            return;
        }
        // 3. 删除数据库中的数据
        BlogDao blogDao = new BlogDao();
        blogDao.delete(Integer.parseInt(blogId));
        // 4. 跳转到博客列表页
        resp.sendRedirect("blog_list.html");
    }
}
