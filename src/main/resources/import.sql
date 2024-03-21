-- Inserção na tabela Category
INSERT INTO Category (category, version) VALUES 
    ('Eletrônicos', 1),
    ('Roupas', 1),
    ('Alimentos', 1);

-- Inserção na tabela Cupom
INSERT INTO Cupom (dataAplicada, desconto, nomeCupom) VALUES 
    ('2023-01-15', 10.0, 'DESCONTO10'),
    ('2023-02-20', 15.0, 'DESCONTO15'),
    ('2023-03-25', 20.0, 'DESCONTO20');



-- Inserção na tabela Produto
INSERT INTO Product (descricao, estoque, nome, nomeImagem, preco, id_category) VALUES 
    ('Smartphone', 100, 'iPhone', 'iphone.jpg', 5000.0, 1),
    ('Camiseta', 200, 'Camiseta Branca', 'camiseta.jpg', 50.0, 2),
    ('Arroz', 300, 'Arroz Integral', 'arroz.jpg', 10.0, 3);

-- Inserção na tabela Usuario
INSERT INTO Usuario (cpf, login, nome, perfil, senha) VALUES 
    ('12345678900', 'usuario1', 'Usuário 1', 1, 'senha1'),
    ('98765432100', 'usuario2', 'Usuário 2', 2, 'senha2'),
    ('11122233344', 'usuario3', 'Usuário 3', 1, 'senha3');

    -- Inserção na tabela Endereco
INSERT INTO Endereco (cep, cidade, estado, numero, rua, id_usuario) VALUES 
    ('12345-678', 'São Paulo', 'SP', '123', 'Rua A', 1),
    ('54321-876', 'Rio de Janeiro', 'RJ', '456', 'Rua B', 2),
    ('98765-432', 'Belo Horizonte', 'MG', '789', 'Rua C', 3);

-- Inserção na tabela Pagamento
INSERT INTO Pagamento (formaPagamento, momento) VALUES 
    (0, '2023-01-01'),
    (1, '2023-02-01'),
    (2, '2023-03-01');

-- Inserção na tabela Pedido
INSERT INTO Pedido (dataPedido, statusPedido, totalPedido, cupom_id, pagamento_id, usuario_id) VALUES 
    ('2023-01-01 10:00:00', 0, 1000.0, 1, 1, 1),
    ('2023-02-01 12:30:00', 1, 1500.0, 2, 2, 2),
    ('2023-03-01 15:45:00', 2, 2000.0, 3, 3, 3);

-- Inserção na tabela ItemPedido
INSERT INTO ItemPedido (preco, quantidade, id_pedido, id_produto) VALUES 
    (25.99, 2, 1, 1),
    (15.5, 3, 2, 2),
    (10.75, 1, 2, 3);

-- Inserção na tabela Telefone
INSERT INTO Telefone (codigoArea, numero, id_usuario) VALUES 
    ('11', '999999999', 1),
    ('21', '888888888', 2),
    ('31', '777777777', 3);
