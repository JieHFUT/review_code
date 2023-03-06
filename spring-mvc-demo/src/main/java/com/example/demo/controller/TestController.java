package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    /**
     * 请求转发
     * @return
     */
    @RequestMapping("/hello")
    public Object hello(){
        return "forward:/login.html";
    }

    /**
     * 请求重定向
     */
    @RequestMapping("/hello2")
    public Object hello2(){
        return "redirect:/reg.html";
    }

}
