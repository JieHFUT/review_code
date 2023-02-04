package com.jieHFUT.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserBeans {

    @Bean(name = "firstUser")
    // @Bean(value = "firstUser")
    // @Bean("firstUser")
    // @Bean(name = {"firstUser", "thirdUser"})
    public User setUser() {
        User user = new User();
        user.setAge(22);
        user.setName("zhangsan");
        return user;
    }
}
