-- Criação da tabela de categorias (opcional, se você quiser categorizar os pratos e bebidas)
CREATE TABLE categorias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

-- Criação da tabela de pratos
CREATE TABLE pratos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10, 2) NOT NULL,
    id_categoria INT,
    FOREIGN KEY (id_categoria) REFERENCES categorias(id) ON DELETE SET NULL
);

-- Criação da tabela de bebidas
CREATE TABLE bebidas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10, 2) NOT NULL,
    id_categoria INT,
    FOREIGN KEY (id_categoria) REFERENCES categorias(id) ON DELETE SET NULL
);

-- Criação de tabela de reservas (exemplo caso você precise integrar com outra funcionalidade)
CREATE TABLE reservas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_cliente VARCHAR(255) NOT NULL,
    data_reserva DATE NOT NULL,
    hora_reserva TIME NOT NULL,
    num_pessoas INT NOT NULL
);

-- Criação de tabela de pedidos (opcional, caso queira adicionar um sistema de pedidos)
CREATE TABLE pedidos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    data_pedido DATE NOT NULL,
    hora_pedido TIME NOT NULL,
    id_prato INT,
    id_bebida INT,
    FOREIGN KEY (id_prato) REFERENCES pratos(id) ON DELETE SET NULL,
    FOREIGN KEY (id_bebida) REFERENCES bebidas(id) ON DELETE SET NULL
);
