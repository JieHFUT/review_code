package com.jieHFUT.controller;


import com.jieHFUT.model.Dog;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
public class DogBean {


    // @Scope("prototype")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean
    public Dog setDog() {
        Dog dog = new Dog();
        dog.setAge(10);
        dog.setName("zhangsan");
        dog.setSex("nan");
        return dog;
    }

}
