
insert into usuario (nome, login , senha,perfil) values('Siririco', 'Cagatronco','O2JdqlPMBBKPaus+zYDOx/D6Ol9IZk9UFD95DcsTQLBD4euH4P9Sh1OrL4c1l4vLPkYjGgxrMFFUy09ouL7vDA==',1);
insert into usuario (nome, login , senha,perfil) values('Ludmilo', 'prexeco','O2JdqlPMBBKPaus+zYDOx/D6Ol9IZk9UFD95DcsTQLBD4euH4P9Sh1OrL4c1l4vLPkYjGgxrMFFUy09ouL7vDA==',2);

insert into telefone (codigoArea, numero) values('63', '9999-9999' );
insert into telefone (codigoArea, numero) values('62', '8888-8888' );
insert into telefone (codigoArea, numero) values('61', '7777-7777' );
insert into telefone (codigoArea, numero) values('55', '6666-6666' );

insert into usuario_telefone (id_usuario, id_telefone) values(1, 1 );
insert into usuario_telefone (id_usuario, id_telefone) values(1, 2 );
insert into usuario_telefone (id_usuario, id_telefone) values(2, 3 );
insert into usuario_telefone (id_usuario, id_telefone) values(2, 4 );

INSERT INTO marca (nome, descricao) VALUES ('Chevrolet', 'Origem Americana, ha mais de 50 anos no mercado');
INSERT INTO marca (nome, descricao) VALUES ('Gurgel', 'Origem Brasileira, ha mais de 20 anos no mercado');
INSERT INTO marca (nome, descricao) VALUES ('Jaguar', 'Origem Inglesa, ha mais de 40 anos no mercado');
INSERT INTO marca (nome, descricao) VALUES ('Honda', 'Origem Japonesa, ha mais de 30 anos no mercado');

INSERT INTO produto (nome, descricao, preco, estoque) VALUES ('Produto 1', 'Kit mecanica Chevy', 2999.99, 10);
INSERT INTO produto (nome, descricao, preco, estoque) VALUES ('Produto 2', 'Kit mecanica Gurgel', 999.99, 5);
INSERT INTO produto (nome, descricao, preco, estoque) VALUES ('Produto 3', 'Kit mecanica Jaguar', 4999.99, 2);
INSERT INTO produto (nome, descricao, preco, estoque) VALUES ('Produto 4', 'Kit mecanica Honda', 3499.99, 20);
INSERT INTO produto (nome, descricao, preco, estoque) VALUES ('Produto 5', 'Caixa de direcao Onix', 1499.99, 20);
INSERT INTO produto (nome, descricao, preco, estoque) VALUES ('Produto 6', 'Motor Honda 1.5 flex', 32999.99, 2);


INSERT INTO marca_produto (id_marca, id_produto) VALUES (1, 1);
INSERT INTO marca_produto (id_marca, id_produto) VALUES (2, 2);
INSERT INTO marca_produto (id_marca, id_produto) VALUES (3, 3);
INSERT INTO marca_produto (id_marca, id_produto) VALUES (4, 4);
INSERT INTO marca_produto (id_marca, id_produto) VALUES (1, 5);
INSERT INTO marca_produto (id_marca, id_produto) VALUES (4, 6);


 INSERT INTO Cliente (nome,login,senha,perfil,email) VALUES
('Cliente 1','sirigueijo','O2JdqlPMBBKPaus+zYDOx/D6Ol9IZk9UFD95DcsTQLBD4euH4P9Sh1OrL4c1l4vLPkYjGgxrMFFUy09ouL7vDA==',2,'cliente1@email.com'),
('Cliente 2','muriçoca','NuCgY6/GPMQTMdNiush/UNx86FJs4rFVBcCfuzRRIREuEbf42eMqkc+ex10zbq4TK4fvrcJUpNH85V1+nUEcJg==',2,'cliente2@email.com' ),
('Cliente 3','mussarela','yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==',2,'cliente3@email.com');

INSERT INTO Endereco (rua,numero,cidade,estado,cep) VALUES
('Avenida Principal', 123, 'SP', 'São Paulo', '12345-678'),
('Rua Secundária', 456, 'RJ', 'Rio de Janeiro', '54321-876'),
('Avenida Central', 789, 'MG', 'Belo Horizonte', '98765-432');

INSERT INTO cliente_endereco (id_cliente, id_endereco) VALUES
(1, 1), 
(2, 2),
(3, 3);

INSERT INTO Cupom (codigo) VALUES
('CUPOM123'),
('CUPOM456'),
('CUPOM789');

INSERT INTO ItemPedido (quantidade, preco) VALUES
(2, 2999.99), -- idProduto = 1
(1, 999.99), --idProduto = 2
(1, 4999.99); --idProduto = 3



INSERT INTO Pedido (codigo, date, id_cliente) VALUES
('PEDIDO001', '2023-10-07', 1), --id_cliente = 1
('PEDIDO002', '2023-10-08', 2), --id_cliente = 2
('PEDIDO002', '2023-10-08', 3); --id_cliente = 3

--INSERT INTO ItemPedido (quantidade, id_pedido) VALUES
--(5, 1),
--(3, 2), 
--(8, 3); 
