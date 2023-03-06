package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest // 当前测试的上下文环境为 springboot
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void getAll() {
        List<UserInfo> list = userMapper.getAll();
        for (UserInfo user : list) {
            System.out.println(user.toString());
        }
    }

    @Test
    void getUserById() {
        UserInfo userInfo = userMapper.getUserById(1);
        System.out.println("userinfo -> " + userInfo);
    }

    @Test
    void getUserByName() {
        UserInfo userInfo = userMapper.getUserByName(null);
        System.out.println("userinfo -> " + userInfo);
    }

    @Test
    void getAllByOrder() {
        List<UserInfo> list = userMapper.getAllByOrder("desc");
        for (UserInfo user : list) {
            System.out.println(user.toString());
        }
    }

    @Test
    void login() {
        String username = "dd";
        String password = "' or 1='1";
        UserInfo userInfo = userMapper.login(username, password);
        System.out.println("userinfo -> " + userInfo);
    }

    @Test
    void add() {
        int result = userMapper.add("老八", "123456", null);
        System.out.println("添加用户结果：" + result);
    }

    @Test
    void delByIds() {
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(9);
        list.add(10);
        int result = userMapper.delByIds(list);
        System.out.println("删除了：" + result);
    }
}