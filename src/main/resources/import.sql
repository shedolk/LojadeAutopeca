
--INSERT INTO cadeira (nome, modelo, material) VALUES ('Cadeira A', 'Modelo 123', 'Madeira');
--INSERT INTO cadeira (nome, modelo, material) VALUES ('Cadeira B', 'Modelo 456', 'Metal');
--INSERT INTO cadeira (nome, modelo, material) VALUES ('Cadeira C', 'Modelo 789', 'Plástico');

--insert into estado (nome, sigla) values('Tocantins', 'TO');
--insert into estado (nome, sigla) values('Goiás', 'GO');
--insert into estado (nome, sigla) values('Rio de Janeiro', 'RJ');
--insert into estado (nome, sigla) values('São Paulo', 'SP');


insert into usuario (nome, login , senha) values('elon musk', 'musk','111' );
insert into usuario (nome, login , senha) values('bill gates', 'gates','222' );

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

INSERT INTO cliente (nome, email) VALUES ('Cliente 1', 'cliente1@email.com');
INSERT INTO cliente (nome, email) VALUES ('Cliente 2', 'cliente2@email.com');
INSERT INTO cliente (nome, email) VALUES ('Cliente 3', 'cliente3@email.com');

INSERT INTO endereco (rua, numero, cidade, estado, cep) VALUES ('Rua 1', 123, 'Cidade 1', 'Estado 1', 'CEP 1');
INSERT INTO endereco (rua, numero, cidade, estado, cep) VALUES ('Rua 2', 456, 'Cidade 2', 'Estado 2', 'CEP 2');
INSERT INTO endereco (rua, numero, cidade, estado, cep) VALUES ('Rua 3', 789, 'Cidade 3', 'Estado 3', 'CEP 3');

INSERT INTO cliente_pedido (id_cliente, id_pedido) VALUES (1, 1);
INSERT INTO cliente_pedido (id_cliente, id_pedido) VALUES (2, 2);
INSERT INTO cliente_pedido (id_cliente, id_pedido) VALUES (3, 3);

INSERT INTO item_pedido (quantidade) VALUES (1);
INSERT INTO item_pedido (quantidade) VALUES (2);
INSERT INTO item_pedido (quantidade) VALUES (3);

INSERT INTO cupom (codigo) VALUES ('Cupom1');
INSERT INTO cupom (codigo) VALUES ('Cupom2');
INSERT INTO cupom (codigo) VALUES ('Cupom3');

INSERT INTO pedido (codigo, date,id_itemPedido, id_endereco, cliente_id) VALUES ('Pedido1', '2023-10-06',2, 1, 1);
INSERT INTO pedido (codigo, date,id_itemPedido, id_endereco, cliente_id) VALUES ('Pedido2', '2023-10-07',1, 2, 2);
INSERT INTO pedido (codigo, date,id_itemPedido, id_endereco, cliente_id) VALUES ('Pedido3', '2023-10-08',3, 3, 3);


INSERT INTO cliente_pedido (id_cliente, id_pedido) VALUES (1, 1);
INSERT INTO cliente_pedido (id_cliente, id_pedido) VALUES (2, 2);
INSERT INTO cliente_pedido (id_cliente, id_pedido) VALUES (3, 3);

INSERT INTO pedido_itempedido (id_pedido, id_itemPedido) VALUES (1, 2);
INSERT INTO pedido_itempedido (id_pedido, id_itemPedido) VALUES (2, 1);
INSERT INTO pedido_itempedido (id_pedido, id_itemPedido) VALUES (3, 3);

INSERT INTO pedido_endereco (id_pedido, id_endereco) VALUES (1, 1);
INSERT INTO pedido_endereco (id_pedido, id_endereco) VALUES (2, 2);
INSERT INTO pedido_endereco (id_pedido, id_endereco) VALUES (3, 3);


INSERT INTO pedido_cliente (id_pedido, id_cliente) VALUES (1, 1);
INSERT INTO pedido_cliente (id_pedido, id_cliente) VALUES (2, 2);
INSERT INTO pedido_cliente (id_pedido, id_cliente) VALUES (3, 3);



