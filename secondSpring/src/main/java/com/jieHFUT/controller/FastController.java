package com.jieHFUT.controller;

import com.jieHFUT.serive.FastSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller   // 来验证前端传过来的参数
public class FastController {
    public void sayController(){
        System.out.println("controller");
    }

    // 读取FastSerive
    // 1. 属性注入
    @Autowired  // 自动装配
    private FastSerive fastSerive;

    public void sayAutowired() {
        fastSerive.saySerive();
    }


    // 2.


}
