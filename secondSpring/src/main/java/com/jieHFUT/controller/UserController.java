package com.jieHFUT.controller;

import com.jieHFUT.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserController {

//    @Resource(name = "firstUser")
//    private User user;
//
//    public void doFirstUser() {
//        System.out.println("user_name" + user.getName());
//    }


    @Autowired
    @Qualifier(value = "firstUser")
    private User user;

    public void doFirstUser() {
        System.out.println("user_name" + user.getName());
    }

}
