-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

insert into usuario (nome, login, senha, perfil) values('Usuario user', 'user', 'O2JdqlPMBBKPaus+zYDOx/D6Ol9IZk9UFD95DcsTQLBD4euH4P9Sh1OrL4c1l4vLPkYjGgxrMFFUy09ouL7vDA==', 1);
insert into usuario (nome, login, senha, perfil) values('Usuario admin', 'admin', 'O2JdqlPMBBKPaus+zYDOx/D6Ol9IZk9UFD95DcsTQLBD4euH4P9Sh1OrL4c1l4vLPkYjGgxrMFFUy09ouL7vDA==', 2);

--insert into usuario (nome, login, senha, perfil) values('Neymar Jr', 'neymar', 'O2JdqlPMBBKPaus+zYDOx/D6Ol9IZk9UFD95DcsTQLBD4euH4P9Sh1OrL4c1l4vLPkYjGgxrMFFUy09ouL7vDA==', 1);
--insert into usuario (nome, login, senha, perfil) values('Ronaldinho Gaucho', 'ronaldinho', 'O2JdqlPMBBKPaus+zYDOx/D6Ol9IZk9UFD95DcsTQLBD4euH4P9Sh1OrL4c1l4vLPkYjGgxrMFFUy09ouL7vDA==', 2);

insert into telefone (codigoArea, numero) values('63', '9999-9999');
insert into telefone (codigoArea, numero) values('62', '8888-8888');
insert into telefone (codigoArea, numero) values('63', '7777-7777');
insert into telefone (codigoArea, numero) values('63', '6666-6666');

insert into usuario_telefone (id_usuario, id_telefone) values(1, 1);
insert into usuario_telefone (id_usuario, id_telefone) values(1, 2);
insert into usuario_telefone (id_usuario, id_telefone) values(2, 3);
insert into usuario_telefone (id_usuario, id_telefone) values(2, 4);

--insert into produto (nome, descricao, categoria, preco, estoque, nomeImagem) values('PRODUTO 1', 'DESCRICAO DO PRODUTO 1', 1, 199.0, 100, 'IMAGEM PRODUTO 1');
--insert into produto (nome, descricao, categoria, preco, estoque, nomeImagem) values('PRODUTO 2', 'DESCRICAO DO PRODUTO 2', 2, 100.0, 100, 'IMAGEM PRODUTO 2');
--insert into produto (nome, descricao, categoria, preco, estoque, nomeImagem) values('PRODUTO 3', 'DESCRICAO DO PRODUTO 3', 3, 100.0, 100, 'IMAGEM PRODUTO 3');
--insert into produto (nome, descricao, categoria, preco, estoque, nomeImagem) values('PRODUTO 4', 'DESCRICAO DO PRODUTO 4', 4, 100.0, 100, 'IMAGEM PRODUTO 4');
--insert into produto (nome, descricao, categoria, preco, estoque, nomeImagem) values('PRODUTO 5', 'DESCRICAO DO PRODUTO 5', 5, 100.0, 100, 'IMAGEM PRODUTO 5');

--insert into produto (nome, descricao, categoria, preco, estoque, nomeImagem) values('PRODUTO 6', 'DESCRICAO DO PRODUTO 6', 1, 399.0, 100, 'IMAGEM PRODUTO 6');
--insert into produto (nome, descricao, categoria, preco, estoque, nomeImagem) values('PRODUTO 7', 'DESCRICAO DO PRODUTO 7', 2, 300.0, 100, 'IMAGEM PRODUTO 7');
--insert into produto (nome, descricao, categoria, preco, estoque, nomeImagem) values('PRODUTO 8', 'DESCRICAO DO PRODUTO 8', 3, 200.0, 100, 'IMAGEM PRODUTO 8');
--insert into produto (nome, descricao, categoria, preco, estoque, nomeImagem) values('PRODUTO 9', 'DESCRICAO DO PRODUTO 9', 4, 50.0, 100, 'IMAGEM PRODUTO 9');
--insert into produto (nome, descricao, categoria, preco, estoque, nomeImagem) values('PRODUTO 10', 'DESCRICAO DO PRODUTO 10', 5, 69.0, 100, 'IMAGEM PRODUTO 10');


insert into category (category, version) values('CATEGORY 1', 0);
insert into category (category, version) values('CATEGORY 2', 0);
insert into category (category, version) values('CATEGORY 3', 0);
insert into category (category, version) values('CATEGORY 4', 0);
insert into category (category, version) values('CATEGORY 5', 0);

insert into product (nome, descricao, id_category, preco, estoque, nomeImagem) values('PRODUCT 1', 'DESCRICAO DO PRODUTO 1', 1, 199.0, 100, 'IMAGEM PRODUTO 1');
insert into product (nome, descricao, id_category, preco, estoque, nomeImagem) values('PRODUCT 2', 'DESCRICAO DO PRODUTO 2', 2, 199.0, 100, 'IMAGEM PRODUTO 2');
insert into product (nome, descricao, id_category, preco, estoque, nomeImagem) values('PRODUCT 3', 'DESCRICAO DO PRODUTO 3', 3, 199.0, 100, 'IMAGEM PRODUTO 3');
insert into product (nome, descricao, id_category, preco, estoque, nomeImagem) values('PRODUCT 4', 'DESCRICAO DO PRODUTO 4', 4, 199.0, 100, 'IMAGEM PRODUTO 4');
insert into product (nome, descricao, id_category, preco, estoque, nomeImagem) values('PRODUCT 5', 'DESCRICAO DO PRODUTO 5', 5, 199.0, 100, 'IMAGEM PRODUTO 5');