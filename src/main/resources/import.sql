
--INSERT INTO cadeira (nome, modelo, material) VALUES ('Cadeira A', 'Modelo 123', 'Madeira');
--INSERT INTO cadeira (nome, modelo, material) VALUES ('Cadeira B', 'Modelo 456', 'Metal');
--INSERT INTO cadeira (nome, modelo, material) VALUES ('Cadeira C', 'Modelo 789', 'Plástico');

--insert into estado (nome, sigla) values('Tocantins', 'TO');
--insert into estado (nome, sigla) values('Goiás', 'GO');
--insert into estado (nome, sigla) values('Rio de Janeiro', 'RJ');
--insert into estado (nome, sigla) values('São Paulo', 'SP');


insert into usuario (nome, login , senha) values('Siririco', 'Cagatronco','123');
insert into usuario (nome, login , senha) values('Ludmilo', 'prexeco','123');

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

 INSERT INTO Endereco (rua,numero,cidade,estado,cep) VALUES
('Avenida Principal', 123, 'SP', 'São Paulo', '12345-678'),
('Rua Secundária', 456, 'RJ', 'Rio de Janeiro', '54321-876'),
('Avenida Central', 789, 'MG', 'Belo Horizonte', '98765-432');


 INSERT INTO Cliente (nome,email) VALUES
('Cliente 1','cliente1@email.com'),
('Cliente 2','cliente2@email.com' ),
('Cliente 3','cliente3@email.com');

INSERT INTO cliente_endereco (id_cliente, id_endereco) VALUES
(1, 1), 
(2, 2),
(3, 3);


INSERT INTO Cupom (codigo) VALUES
('CUPOM123'),
('CUPOM456'),
('CUPOM789');


INSERT INTO Pedido (codigo, date, id_cliente) VALUES
('PEDIDO001', '2023-10-07', 1), 
('PEDIDO002', '2023-10-08', 2),
('PEDIDO003', '2023-10-09', 3); 

INSERT INTO ItemPedido (quantidade, id_pedido) VALUES
(5, 1),
(3, 2), 
(8, 3); 
