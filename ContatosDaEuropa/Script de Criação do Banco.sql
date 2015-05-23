create database dbContatos;
use dbContatos;
create table usuarios (cd_usuario varchar(50) not null, senha varchar(100) not null, primary key (cd_usuario, senha));
create table contatos (nome varchar(50) not null , apelido varchar(20) not null, telephone char(10),celular char(10), email varchar(30), dt_nasc date, constraint pk_contato primary key (nome));