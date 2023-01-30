create database if not exists blog_system;

use blog_system;

drop table if exists blog;
create table blog (
    blogId int primary key auto_increment,
    title varchar(1024), -- 博客标题
    content mediumtext,  -- 博客正文
    userId int,    -- 作者的 id
    postTime datetime  -- 发布时间
);

drop table if exists user;
create table user (
    userId int primary key auto_increment,
    username varchar(128) unique,
    password varchar(128)
);