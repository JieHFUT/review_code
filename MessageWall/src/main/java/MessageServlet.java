import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 对应到前端传来的请求的 body 格式.
// 此处要保证, 每个属性的名字都和 json 里的 key 对应 (顺序可以不一样)
// 同时也要保证这几个属性是 public 或者提供 public 的 getter 方法
class Message {
    public String from;
    public String to;
    public String message;

    @Override
    public String toString() {
        return "Message{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

@WebServlet("/message")
public class MessageServlet extends HttpServlet {
    // 由于 ObjectMapper 会在多个方法中使用, 就提出来, 作为成员变量
    private ObjectMapper objectMapper = new ObjectMapper();
    // private List<Message> messageList = new ArrayList<>();

    // 负责实现让客户端提交数据给服务器.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 把 body 的 json 数据解析出来.
        Message message = objectMapper.readValue(req.getInputStream(), Message.class);
        // 2. 把这个对象保存起来. 最简单的办法, 就是直接存到内存中.
        // messageList.add(message);
        save(message);
        System.out.println("message: " + message);
        // 3. 返回保存成功的响应
        resp.setContentType("application/json;charset=utf8");
        resp.getWriter().write("{ \"ok\": 1 }");
    }

    // 负责实现让客户端从服务器拿到数据.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 由于约定的请求, 没有参数, 不需要进行任何解析操作~~
        resp.setContentType("application/json;charset=utf8");
        // 把对象转成 json 格式的字符串. 此处 messageList 是一个 List, 直接就被转成 json 数组了.
        List<Message> messageList = load();
        String respString = objectMapper.writeValueAsString(messageList);
        resp.getWriter().write(respString);
    }

    // 把当前的消息存到数据库中
    private void save(Message message) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // 1. 和数据库建立连接
            connection = DBUtil.getConnection();
            // 2. 构造 SQL 语句
            String sql = "insert into message values(?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, message.from);
            statement.setString(2, message.to);
            statement.setString(3, message.message);
            // 3. 执行 SQL 语句
            int ret = statement.executeUpdate();
            if (ret != 1) {
                System.out.println("插入失败!");
            } else {
                System.out.println("插入成功!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭连接.
            DBUtil.close(connection, statement, null);
        }
    }

    // 从数据库查询到记录
    private List<Message> load() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Message> messageList = new ArrayList<>();
        try {
            // 1. 建立连接
            connection = DBUtil.getConnection();
            // 2. 构造 SQL
            String sql = "select * from message";
            statement = connection.prepareStatement(sql);
            // 3. 执行 SQL
            resultSet = statement.executeQuery();
            // 4. 遍历结果集
            while (resultSet.next()) {
                Message message = new Message();
                message.from = resultSet.getString("from");
                message.to = resultSet.getString("to");
                message.message = resultSet.getString("message");
                messageList.add(message);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // 5. 释放资源
            DBUtil.close(connection, statement, resultSet);
        }
        return messageList;
    }
}
