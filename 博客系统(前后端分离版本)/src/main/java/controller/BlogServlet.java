package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Blog;
import model.BlogDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/blog")
public class BlogServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf8");
        String blogId = req.getParameter("blogId");
        BlogDao blogDao = new BlogDao();
        if (blogId == null) {
            // 不存在 blogId 这个参数, 这就是获取博客列表.
            List<Blog> blogs = blogDao.selectAll();
            String jsonString = objectMapper.writeValueAsString(blogs);
            resp.getWriter().write(jsonString);
        } else {
            // 存在 blogId 参数, 就是获取博客详情.
            Blog blog = blogDao.selectOne(Integer.parseInt(blogId));
            String jsonString = objectMapper.writeValueAsString(blog);
            resp.getWriter().write(jsonString);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        // 1. 获取到用户的登录状态.
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
        // 2. 读取请求的内容
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        if (title == null || title.equals("") || content == null || content.equals("")) {
            resp.setStatus(400);
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("请求中的标题或正文不完整");
            return;
        }
        // 3. 构造 Blog 对象, 并插入到数据库中.
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        // 博客的作者. 作者是谁? 当前谁登录, 作者就是谁!!
        blog.setUserId(user.getUserId());
        BlogDao blogDao = new BlogDao();
        blogDao.insert(blog);
        // 4. 插入成功之后, 跳转到博客列表页.
        resp.sendRedirect("blog_list.html");
    }
}
