-- code_group
create table code_group
(
    group_code varchar(3)                             not null
        primary key,
    group_name varchar(30)                            not null,
    use_yn     varchar(1) default 'Y'                 not null,
    reg_date   datetime   default current_timestamp() not null,
    upd_date   datetime   default current_timestamp() not null on update current_timestamp()
);

-- code_detail
create table code_detail
(
    group_code varchar(3)                             not null,
    code_value varchar(3)                             not null,
    code_name  varchar(30)                            not null,
    sort_seq   int(10)                                not null,
    use_yn     varchar(1) default 'Y'                 not null,
    reg_date   datetime   default current_timestamp() not null,
    upd_date   datetime   default current_timestamp() not null on update current_timestamp(),
    primary key (code_value, group_code),
    constraint code_detail_ibfk_1
        foreign key (group_code) references code_group (group_code)
);

create index group_code
    on code_detail (group_code);

-- member
create table member (
    user_no bigint not null auto_increment ,
    user_id varchar(50) not null,
    user_pw varchar(200) not null,
    user_name varchar(100) not null,
    job varchar(3) not null,
    coin int not null,
    reg_date   datetime   default current_timestamp() not null,
    upd_date   datetime   default current_timestamp() not null on update current_timestamp(),
    primary key (user_no)
);

-- member_auth
create table member_auth (
    user_auth_no bigint not null auto_increment,
    user_no bigint,
    auth varchar(50),
    reg_date   datetime   default current_timestamp() not null,
    upd_date   datetime   default current_timestamp() not null on update current_timestamp(),
    primary key (user_auth_no),
    foreign key (user_no) references member(user_no)
);

-- alter table code_group
--     change column use_yn use_yn varchar(1) not null default 'Y',
--     change column reg_date reg_date datetime not null default current_timestamp,
--     change column upd_date upd_date datetime not null default current_timestamp on update CURRENT_TIMESTAMP
-- ;
--
-- alter table code_detail
--     change column use_yn use_yn varchar(1) not null default 'Y',
--     change column reg_date reg_date datetime not null default current_timestamp,
--     change column upd_date upd_date datetime not null default current_timestamp on update CURRENT_TIMESTAMP
-- ;

insert into code_group (group_code, group_name) values ('A01', 'job');
insert into code_group (group_code, group_name) values ('A02', 'hobby');

insert into code_detail (group_code, code_value, code_name, sort_seq)
values ('A01', '00', '---', 1);
insert into code_detail (group_code, code_value, code_name, sort_seq)
values ('A01', '01', 'Developer', 2);
insert into code_detail (group_code, code_value, code_name, sort_seq)
values ('A01', '02', 'Designer', 3);
insert into code_detail (group_code, code_value, code_name, sort_seq)
values ('A01', '03', 'Archiect', 4);

insert into code_detail (group_code, code_value, code_name, sort_seq)
values ('A02', '00', '---', 1);
insert into code_detail (group_code, code_value, code_name, sort_seq)
values ('A02', '01', 'Movie', 2);
insert into code_detail (group_code, code_value, code_name, sort_seq)
values ('A02', '02', 'Music', 3);
insert into code_detail (group_code, code_value, code_name, sort_seq)
values ('A02', '03', 'Sports', 4);


set foreign_key_checks = 0;
truncate code_group;
truncate code_detail;
set foreign_key_checks = 1;
