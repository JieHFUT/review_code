package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户表 mapper
 */
@Mapper
public interface UserMapper {

    public int add(@Param("username") String username,
                   @Param("password") String password);

    public UserInfo login(@Param("username") String username,
                          @Param("password") String password);

    public UserInfo getUserByName(@Param("username") String username);


}
