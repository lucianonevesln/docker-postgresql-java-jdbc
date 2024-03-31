Projeto: CRUD Lista de Tarefas com Java JDBC

Objetivo: inspirado em um curso finalizado em 31/03/2024, sobre JDBC, criei esse projeto para praticar o conteúdo abordado nele. Trata-se de um CRUD bem simples que permite as operações mais fundamentais com banco de dados (criar, ler, editar e excluir lançamento). 

Tecnologias Utilizadas:

- Docker;
- PostgreSQL;
- Java;
- JDBC.

Script SQL para criação de Banco de Dados e Tabela:

```
create database lista_de_tarefas;

create table lista_de_tarefas (
    id SERIAL primary key,
    nome varchar(50) default null,
    descricao varchar(140) default null,
    ativo boolean default null, 
    data_de_cadastro timestamp(6) default null,
    data_de_alteracao timestamp(6) default null
);
```
