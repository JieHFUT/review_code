package com.example.demo.model;

import lombok.Data;

import java.util.Date;

/**
 * 普通的实体类，用于 Mybatis 做数据库表（userinfo表）的映射的
 * 注意事项：保证类属性名称和userinfo表的字段完全一致。
 */
@Data
public class UserInfo {
    private int id;
    private String name;
    private String password;
    private String photo;
    private Date createtime;
    private Date updatetime;
    private int state;
}
