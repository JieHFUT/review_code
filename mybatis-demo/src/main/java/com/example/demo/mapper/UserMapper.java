package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper // mybaits 接口，此注解一定不能忽略
public interface UserMapper {
    // 查询所有的信息
    public List<UserInfo> getAll();

    // 查询所有的信息（根据排序条件进行排序）
    public List<UserInfo> getAllByOrder(@Param("order") String order);

    // 根据用户id查询用户
    public UserInfo getUserById(@Param("uid") Integer id);

    // 根据用户姓名完全匹配查询
    public UserInfo getUserByName(@Param("username") String username);

    public UserInfo login(@Param("username") String username,
                          @Param("password") String password);

    // 多条用户的删除
    public int delByIds(List<Integer> ids);

    // 添加用户
    public int add(@Param("username") String username,
                   @Param("password") String password,
                   @Param("photo") String photo);
}
