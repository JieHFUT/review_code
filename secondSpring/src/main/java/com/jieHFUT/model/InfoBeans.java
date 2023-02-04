package com.jieHFUT.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class InfoBeans {

    @Bean(name = "secondUser")
    public User setUser() {
        User user = new User();
        user.setAge(22);
        user.setName("lisi");
        return user;
    }
}
