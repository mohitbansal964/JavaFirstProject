DROP DATABASE EFS_DB;
CREATE DATABASE EFS_DB;
USE EFS_DB;

create table MODULES
(
  modulecode char(5) primary key,
  modulename varchar(50),
  duration int
 );
create table courses
(
 coursecode int primary key,
 title varchar(50),
 fees int);
create table courseandmodules
(
  coursecode int ,
  modulecode char(5) , 
  primary key (coursecode, modulecode)
 );
create table trainers
(
  trainerid int primary key,
  trainername varchar(50),
  email varchar(32)
 );
create table batches
(
  batchcode int primary key,
  trainerid int,
  coursecode int,
  startdate date,
  capacity int,
  batchstrength  int,
  slotscode char(2) );
create table students
(
  studentid int,
  studentname varchar(50),
  batchcode int references batches(batchcode),
  place varchar(30),
  phone varchar(10),
  primary key ( studentid, batchcode) 
 );