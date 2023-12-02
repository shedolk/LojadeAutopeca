-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

insert into usuario (nome, login, senha, cpf, perfil) values('Usuario user', 'user', 'O2JdqlPMBBKPaus+zYDOx/D6Ol9IZk9UFD95DcsTQLBD4euH4P9Sh1OrL4c1l4vLPkYjGgxrMFFUy09ouL7vDA==', '12345678900',1);
insert into usuario (nome, login, senha, cpf, perfil) values('Usuario admin', 'admin', 'O2JdqlPMBBKPaus+zYDOx/D6Ol9IZk9UFD95DcsTQLBD4euH4P9Sh1OrL4c1l4vLPkYjGgxrMFFUy09ouL7vDA==', '98765432111',2);

INSERT INTO Endereco (rua,numero,cidade, estado,cep) VALUES
('Rua A','123','Cidade1','Estado1','12345-678'),
('Rua b','456','Cidade2','Estado2','87654-321'),
('Rua c','789','Cidade3','Estado3','11111-111');

insert into usuario_endereco (id_usuario, id_endereco) values (1,1);
insert into usuario_endereco (id_usuario, id_endereco) values (1,2);
insert into usuario_endereco (id_usuario, id_endereco) values (2,3);

insert into telefone (codigoArea, numero) values('63', '9999-9999');
insert into telefone (codigoArea, numero) values('62', '8888-8888');
insert into telefone (codigoArea, numero) values('63', '7777-7777');
insert into telefone (codigoArea, numero) values('63', '6666-6666');

insert into usuario_telefone (id_usuario, id_telefone) values(1, 1);
insert into usuario_telefone (id_usuario, id_telefone) values(1, 2);
insert into usuario_telefone (id_usuario, id_telefone) values(2, 3);
insert into usuario_telefone (id_usuario, id_telefone) values(2, 4);


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


INSERT INTO Pedido (dataHoraPedido, pagamento, totalPedido, id_usuario) VALUES
    ('2023-01-01 10:00:00', 1, 597.00, 1),
    ('2023-02-01 12:30:00', 2, 398.00, 2);


INSERT INTO ItemPedido (quantidade, preco, id_produto, id_pedido) VALUES
    (1, 199.0, 1, 1),
    (2, 199.0, 2, 1),
    (2, 199.0, 3, 2);
    


