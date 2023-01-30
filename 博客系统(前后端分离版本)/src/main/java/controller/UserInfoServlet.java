package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Blog;
import model.BlogDao;
import model.User;
import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/userInfo")
public class UserInfoServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String blogId = req.getParameter("blogId");

        // 先获取一下当前是哪个用户登录的
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.setStatus(403);
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("当前未登录!");
            return;
        }
        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.setStatus(403);
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("当前未登录!");
            return;
        }

        if (blogId == null) {
            // 请求来自博客列表页, 直接返回登录的用户信息.
            user.setPassword("");
            resp.setContentType("application/json; charset=utf8");
            String jsonString = objectMapper.writeValueAsString(user);
            resp.getWriter().write(jsonString);
        } else {
            // 请求来自博客详情页, 返回文章作者信息.
            BlogDao blogDao = new BlogDao();
            Blog blog = blogDao.selectOne(Integer.parseInt(blogId));
            if (blog == null) {
                resp.setStatus(403);
                resp.setContentType("text/html;charset=utf8");
                resp.getWriter().write("当前 blogId 有误!");
                return;
            }
            UserDao userDao = new UserDao();
            // author 是博客的作者
            User author = userDao.selectById(blog.getUserId());
            if (author == null) {
                resp.setStatus(403);
                resp.setContentType("text/html;charset=utf8");
                resp.getWriter().write("当前博客对应的作者没有找到!");
                return;
            }
            author.setPassword("");
            if (user.getUserId() == author.getUserId()) {
                author.setIsYourBlog(1);
            } else {
                author.setIsYourBlog(0);
            }
            resp.setContentType("application/json; charset=utf8");
            String jsonString = objectMapper.writeValueAsString(author);
            resp.getWriter().write(jsonString);
        }
    }
}
