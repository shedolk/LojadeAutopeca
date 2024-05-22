-- Inserção na tabela Category
--INSERT INTO Category (category, version) VALUES 
   -- ('SUSPENSAO PADRAO', 1),
   -- ('SUSPENSAO ESPORTIVA', 1),
   -- ('SUSPENSAO OFF-ROAD', 1);

-- Inserir dados técnicos para uma suspensão dianteira para carros da Marca A, Modelo X
INSERT INTO dadostecnicos (compatibilidade, tipoMola, tipoAmortecedor, fornecedor, embalagem, peso) 
VALUES ('Marca A - Modelo X', 'Mola helicoidal', 'Amortecedor hidráulico', 'Fabricante A', 'Caixa individual', 15);

-- Inserir dados técnicos para uma suspensão traseira para carros da Marca B, Modelo Y
INSERT INTO dadostecnicos (compatibilidade, tipoMola, tipoAmortecedor, fornecedor, embalagem, peso) 
VALUES ('Marca B - Modelo Y', 'Mola a gás', 'Amortecedor a ar', 'Fabricante B', 'Embalagem de plástico', 18);

-- Inserir dados técnicos para uma suspensão dianteira reforçada para caminhonetes da Marca C, Modelo Z
INSERT INTO dadostecnicos (compatibilidade, tipoMola, tipoAmortecedor, fornecedor, embalagem, peso) 
VALUES ('Marca C - Modelo Z', 'Mola reforçada', 'Amortecedor de alta resistência', 'Fabricante C', 'Caixa resistente', 22);

-- Inserção na tabela Category
-- INSERT INTO Category (category, material) VALUES 
--     ('SUSPENSAO PADRAO', 'ferro'),
--     ('SUSPENSAO ESPORTIVA', 'ferro reforcado'),
--     ('SUSPENSAO OFF-ROAD', 'aço');

INSERT INTO Category (category, compatibilidade, tipoMola, tipoAmortecedor) VALUES 
    ('SUSPENSAO PADRAO', 'HATCHS', 'Mola helicoidal', 'Amortecedor Hidráulico'),
    ('SUSPENSAO ESPORTIVA', 'SEDANS', 'Mola de Flexão', 'Amortecedor Hidráulico'),
    ('SUSPENSAO OFF-ROAD', 'OFF-ROAD', 'Mola de Torção', 'Amortecedor Pressurizado');

-- Inserção na tabela Cupom
INSERT INTO Cupom (dataAplicada, desconto, nomeCupom) VALUES 
    ('2023-01-15', 10.0, 'DESCONTO10'),
    ('2023-02-20', 15.0, 'DESCONTO15'),
    ('2023-03-25', 20.0, 'DESCONTO20');



-- Inserção na tabela Produto
INSERT INTO Product (descricao, estoque, nome, nomeImagem, preco, id_category) VALUES 
    ('FALCON 2000', 100, 'Falcon', 'falcon.jpg', 500.0, 1),
    ('X-SPORT 1000', 200, 'X-Sport', 'xsport.jpg', 750.0, 2),
    ('X-COUNTRY', 300, 'CROSS Susp', 'cross.jpg', 1000.0, 3);

-- Inserção na tabela Usuario
INSERT INTO Usuario (cpf, login, nome, perfil, senha) VALUES 
    ('12345678900', 'usuario1', 'Usuário 1', 1, 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q=='),
    ('98765432100', 'usuario2', 'Usuário 2', 2, 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q=='),
    ('11122233344', 'usuario3', 'Usuário 3', 1, 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==');

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

INSERT INTO ItemPedido (quantidade, preco, id_pedido, id_produto) VALUES 
    (2, 25.99, 1, 1),
    (3, 15.5, 2, 2),
    (1, 10.75, 2, 3);


-- Inserção na tabela Telefone
INSERT INTO Telefone (codigoArea, numero, id_usuario) VALUES 
    ('11', '999999999', 1),
    ('21', '888888888', 2),
    ('31', '777777777', 3);
