package com.jieHFUT.controller;


import com.jieHFUT.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class DogBean {

    @Bean
    public Dog setDog() {
        Dog dog = new Dog();
        dog.setAge(10);
        dog.setName("zhangsan");
        dog.setSex("nan");
        return dog;
    }

}
