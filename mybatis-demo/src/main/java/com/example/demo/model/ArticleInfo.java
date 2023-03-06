package com.example.demo.model;

import lombok.Data;

import java.util.Date;

/**
 * 文章表的实体类
 * DBA（数据库工程师）
 */
@Data
public class ArticleInfo {
    private int id;
    private String title;
    private String content;
    private Date createtime;
    private Date updatetime;
    private int uid;
    private int rcount; // 访问量
    private int state; // 状态（预览字段）
    private String name; // 文章作者名
    //..
}
