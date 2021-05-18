create schema bichegnfei;
create schema test001;
create schema test002;
set schema bichegnfei;

create table user(
    id int primary key auto_increment,
    username varchar(50)
);