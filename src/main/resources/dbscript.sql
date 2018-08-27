create table user (
       id integer not null auto_increment,
        password varchar(255),
        username varchar(255),
        primary key (id)
    ) type=MyISAM


insert into user (id, username, password) values (1, "admin", "admin");
