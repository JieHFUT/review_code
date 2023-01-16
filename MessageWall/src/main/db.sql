create database MessageWall;

use MessageWall;

drop table if exists MessageWall;
create table MessageWall (
    `from` varchar(100),
    `to` varchar(100),
    message varchar(1024)
);