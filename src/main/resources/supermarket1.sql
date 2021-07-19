CREATE DATABASE IF NOT EXISTS Supermarket;

USE Supermarket;

CREATE TABLE IF NOT EXISTS market(
id int not null auto_increment,
name text not null,
price float,
quantity int,
primary key (id)
);
