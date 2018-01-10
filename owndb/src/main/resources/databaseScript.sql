# owndb database
drop database if exists owndb;
create database owndb char set utf8;
use owndb;

# user table
drop table if exists user;
create table user(
	uid		int		auto_increment,
	name	varchar(255) not null,
    constraint pk_uid primary key(uid)
) engine InnoDB;

alter table user add sex int;

# goal table
drop table if exists goal;
create table goal(
	goalId		int		auto_increment,
    name		varchar(30)		not null,
    description	varchar(255),
    start_time	datetime,
    end_time	datetime,
    constraint	pk_goalId	primary key (goalId)
)engine InnoDB;

# table gift
drop table if exists gift;
create table gift(
	gid		int		auto_increment,
    name	varchar(30)		not null,
    description		varchar(255),
    cost	double,
    flag	varchar(30)		not null,
    author	varchar(30),
    origin	varchar(255),
    constraint pk_gid primary key(gid)
)engine InnoDB;

# table country
drop table if exists country;
create table country(
	countryId		varchar(50)		not null,
    name			varchar(255)	not null,
    constraint pk_countryId 	primary key(countryId)
)engine innodb;

# table capital
drop table if exists capital;
create table capital(
	capitalId		varchar(50)		not null,
    countryId		varchar(50)		not null,
    name			varchar(255)	not null,
    constraint	pk_capitalId	primary key(capitalId)
)engine innodb;

# table province
drop table if exists Province;
create table Province(
	provinceId		varchar(50)		not null,
    countryId		varchar(50)		not null,
    name			varchar(255)	not null,
    constraint pk_provinceId	primary key(provinceId)
)engine innodb;

drop table if exists role;
create table role(
	rid		int		auto_increment,
    name	varchar(255)	not null,
    constraint pk_rid	primary key(rid)
)engine innodb;

drop table if exists groups;
create table groups(
	gid		int		auto_increment,
    name	varchar(255)	not null,
    constraint	pk_gid	primary key(gid)
)engine innodb;

drop table if exists role_groups;
create table role_groups(
	rid		int,
    gid		int,
    constraint fk_rid	foreign key(rid) references role(rid)on delete cascade,
    constraint fk_gid	foreign key(gid) references groups(gid)on delete cascade
)engine innodb;