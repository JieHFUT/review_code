package com.jieHFUT.controller;

import com.jieHFUT.serive.FastSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

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
    private FastSerive fastSerive3;

    @Autowired
    public FastController(FastSerive fastSerive) {
        this.fastSerive3 = fastSerive;
    }

    public void sayConstruct() {
        fastSerive3.saySerive();
    }




    // 4. 另外一种注入关键字(实现对象注入)
    @Resource
    private FastSerive fastSerive4;

    public void doFastSerive() {
        fastSerive4.saySerive();
    }





    // 5. resource关键字的setter注入
    private FastSerive fastSerive5;

    @Resource
    public void setFastSerive5(FastSerive fastSerive) {
        this.fastSerive5 = fastSerive;
    }

    public void doSetter() {
        fastSerive5.saySerive();
    }


    // 6. resource不支持构造方法的注入

}
