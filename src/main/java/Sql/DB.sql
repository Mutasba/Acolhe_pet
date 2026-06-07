CREATE DATABASE IF NOT EXISTS acolhe_pet;

USE acolhe_pet;


CREATE TABLE IF NOT EXISTS user (

    id INT PRIMARY KEY AUTO_INCREMENT,

    nome VARCHAR(100) NOT NULL,

    email VARCHAR(150) NOT NULL UNIQUE,

    senha_hash VARCHAR(255) NOT NULL,

    tipo VARCHAR(50),

    ativo BOOLEAN DEFAULT TRUE

);


CREATE TABLE IF NOT EXISTS adotante (

    id INT PRIMARY KEY AUTO_INCREMENT,

    nome VARCHAR(100) NOT NULL,

    cpf VARCHAR(14) UNIQUE NOT NULL,

    email VARCHAR(150),

    telefone VARCHAR(20),

    endereco VARCHAR(255),

    data_cadastro DATE

);


CREATE TABLE IF NOT EXISTS animal (

    id INT PRIMARY KEY AUTO_INCREMENT,

    nome VARCHAR(100) NOT NULL,

    foto VARCHAR(255),

    tipo VARCHAR(50) DEFAULT '',

    cor VARCHAR(50) DEFAULT '',

    idade INT DEFAULT 0,

    genero CHAR(1) DEFAULT 'N',

    raca VARCHAR(100) DEFAULT '',

    deficiencia BOOLEAN DEFAULT FALSE,

    castrado BOOLEAN DEFAULT FALSE,

    peso FLOAT DEFAULT 0,

    porte CHAR(1) DEFAULT 'N',

    fiv BOOLEAN DEFAULT FALSE,

    felv BOOLEAN DEFAULT FALSE,

    estado ENUM(
        'NAO_ADOTADO',
        'EM_PROCESSO',
        'ADOTADO'
    ) DEFAULT 'NAO_ADOTADO' not null,

    data_entrada DATE

);


CREATE TABLE IF NOT EXISTS vacina (

    id INT PRIMARY KEY AUTO_INCREMENT,

    nome VARCHAR(100) NOT NULL

);


CREATE TABLE IF NOT EXISTS preferencias (

    id INT PRIMARY KEY AUTO_INCREMENT,

    adotante_id INT UNIQUE,

    tipo VARCHAR(50) DEFAULT '',

    cor VARCHAR(50) DEFAULT '',

    idade INT DEFAULT 0,

    genero CHAR(1) DEFAULT 'N',

    raca VARCHAR(100) DEFAULT '',

    deficiencia BOOLEAN DEFAULT FALSE,

    castrado BOOLEAN DEFAULT FALSE,

    peso FLOAT DEFAULT 0,

    porte CHAR(1) DEFAULT 'N',

    fiv BOOLEAN DEFAULT FALSE,

    felv BOOLEAN DEFAULT FALSE,

    FOREIGN KEY (adotante_id)
    REFERENCES adotante(id)

);


CREATE TABLE IF NOT EXISTS adocao (

    id INT PRIMARY KEY AUTO_INCREMENT,

    adotante_id INT NOT NULL,

    animal_id INT UNIQUE NOT NULL,

    usuario_id INT,

    data_adocao DATE,

    status ENUM(
        'EM_PROCESSO',
        'FINALIZADA',
        'CANCELADA'
    ) DEFAULT 'EM_PROCESSO',
    observacao varchar(255),
    FOREIGN KEY (adotante_id)
    REFERENCES adotante(id),

    FOREIGN KEY (animal_id)
    REFERENCES animal(id),

    FOREIGN KEY (usuario_id)
    REFERENCES user(id)

);


CREATE TABLE IF NOT EXISTS historico (

    id INT PRIMARY KEY AUTO_INCREMENT,

    usuario_id INT,

    animal_id INT,

    adotante_id INT,

    acao VARCHAR(255),

    data_evento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (usuario_id)
    REFERENCES user(id),

    FOREIGN KEY (animal_id)
    REFERENCES animal(id),

    FOREIGN KEY (adotante_id)
    REFERENCES adotante(id)

);


CREATE TABLE IF NOT EXISTS notificacao (

    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo varchar (255),
 
    mensagem VARCHAR(255),
     tipo varchar (255),
    visualizada BOOLEAN DEFAULT FALSE,

    data TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);

CREATE TABLE IF NOT EXISTS animal_vacina (

    id INT PRIMARY KEY AUTO_INCREMENT,

    animal_id INT NOT NULL,

    vacina_id INT NOT NULL,

    data_aplicacao DATE,

    data_reforco DATE,

    FOREIGN KEY (animal_id)
    REFERENCES animal(id),

    FOREIGN KEY (vacina_id)
    REFERENCES vacina(id)

);