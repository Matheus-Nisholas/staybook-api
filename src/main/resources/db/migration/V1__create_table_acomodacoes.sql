CREATE TABLE tb_acomodacoes (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    descricao TEXT,
    identificador VARCHAR(100) NOT NULL UNIQUE,
    preco NUMERIC(10, 2) NOT NULL,
    status VARCHAR(30) NOT NULL,
    acomodacao_tipo VARCHAR(30) NOT NULL,
    data_de_criacao TIMESTAMP NOT NULL
);