package com.jieHFUT.controller;

import com.jieHFUT.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DogController {

    @Autowired
    private Dog dog;

    public void doDisplay() {
        System.out.println("DogController. ");
        System.out.println("修改前" + dog.toString());
        this.dog.setName("xiaobiesan");
        System.out.println("修改后" + dog.toString());

    }



}
