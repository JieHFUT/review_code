package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 针对博客要实现的功能:
// 1. 新增博客 (博客编辑页)
// 2. 查询出博客列表 (博客列表页)
// 3. 查询出指定博客的详情 (博客详情页)
// 4. 删除指定的博客 (可以在博客详情页中加入)
public class BlogDao {
    // 下列代码都是 JDBC 操作. 代码相似性非常高的!!

    // 此处的 Blog 对象是前端提交给后端的.
    public void insert(Blog blog) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // 1. 先和数据库建立连接
            connection = DBUtil.getConnection();
            // 2. 构造 SQL 语句
            String sql = "insert into blog values(null, ?, ?, ?, now())";
            statement = connection.prepareStatement(sql);
            statement.setString(1, blog.getTitle());
            statement.setString(2, blog.getContent());
            statement.setInt(3, blog.getUserId());
            // 3. 执行 SQL
            int ret = statement.executeUpdate();
            if (ret == 1) {
                System.out.println("插入成功!");
            } else {
                System.out.println("插入失败!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    // 当前这个方法, 是给博客列表页使用的.
    // 博客列表页里面, 不需要显示博客的完整正文, 只需要有一小部分即可 (作为一个用来预览的摘要)
    public List<Blog> selectAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Blog> blogs = new ArrayList<>();
        try {
            // 1. 和数据库建立连接
            connection = DBUtil.getConnection();
            // 2. 构造 SQL
            String sql = "select * from blog order by postTime desc";
            statement = connection.prepareStatement(sql);
            // 3. 执行 SQL
            resultSet = statement.executeQuery();
            // 4. 遍历结果集合.
            while (resultSet.next()) {
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                String content = resultSet.getString("content");
                // 只截取前 100 个字符作为摘要. 注意! 此处的 100 是拍脑门的!!
                // 具体设置成几~~ 没关系, 只要最终的效果正确好看即可!
                if (content.length() > 100) {
                    content = content.substring(0, 100);
                }
                blog.setContent(content);
                blog.setUserId(resultSet.getInt("userId"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                blogs.add(blog);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return blogs;
    }

    public Blog selectOne(int blogId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            // 1. 和数据库建立连接
            connection = DBUtil.getConnection();
            // 2. 构造 SQL
            String sql = "select * from blog where blogId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, blogId);
            // 3. 执行 SQL
            resultSet = statement.executeQuery();
            // 4. 遍历结果集. 由于是按照 blogId 来查询. blogId 是自增主键, 不能重复.
            //    此处的查询结果不可能是多条记录. 只能是 1 条或者 0 条.
            if (resultSet.next()) {
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                blog.setContent(resultSet.getString("content"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                blog.setUserId(resultSet.getInt("userId"));
                return blog;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // 5. 关闭资源
            DBUtil.close(connection, statement, resultSet);
        }

        return null;
    }

    public void delete(int blogId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "delete from blog where blogId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, blogId);
            int ret = statement.executeUpdate();
            if (ret == 1) {
                System.out.println("删除成功!");
            } else {
                System.out.println("删除失败!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }
}
