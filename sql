create database students;
use students;
create table student(
id int primary key auto_increment,
name varchar(45) not null,
phone bigint not null unique,
mail varchar(45) not null,
branch varchar(45) not null,
loc varchar(45) not null,
password varchar(45) not null,
date datetime);
