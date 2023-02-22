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
    private FastSerive fastSerive1;

    public void sayAutowired() {
        fastSerive1.saySerive();
    }




    // 2.setter 注入
    private FastSerive fastSerive2;
    @Autowired
    public void setFastSerive2(FastSerive fastSerive) {
        this.fastSerive2 = fastSerive;
    }

    public void saySetter() {
        fastSerive2.saySerive();
    }



    // 3. 构造方法注入



}
