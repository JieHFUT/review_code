package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.ArticleInfo;
import com.example.demo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<UserInfo> getAll(){
        return userMapper.getAll();
    }

}
