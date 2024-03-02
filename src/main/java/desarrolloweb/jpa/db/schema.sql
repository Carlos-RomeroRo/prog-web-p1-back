DROP DATABASE IF EXISTS testing_spring_jpa;

CREATE DATABASE testing_spring_jpa;

\c testing_spring_jpa

-- Table for users
CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    edad INTEGER NOT NULL,
    password VARCHAR(100) NOT NULL,
    rep_password VARCHAR(100) NOT NULL CHECK (password = rep_password),
    enabled BOOLEAN NOT NULL,
    foto VARCHAR(255),
    rol VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- Table for messages
CREATE TABLE mensajes (
    id SERIAL PRIMARY KEY,
    creador_email VARCHAR(100) NOT NULL REFERENCES usuarios(email),
    destinatario_email VARCHAR(100) NOT NULL REFERENCES usuarios(email),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    contenido TEXT
);

CREATE TABLE usuarios_partidas (
    id SERIAL PRIMARY KEY,
    usuario_id INT NOT NULL REFERENCES usuarios(id),
    partida_id INT NOT NULL REFERENCES partidas(id),
    UNIQUE (usuario_id, partida_id)
);

-- Table for partidas
CREATE TABLE partidas (
    id SERIAL PRIMARY KEY,
    creador_email VARCHAR(100) NOT NULL REFERENCES usuarios(email),
    deporte VARCHAR(100) NOT NULL,
    ciudad VARCHAR(100) NOT NULL,
    provincia VARCHAR(100) NOT NULL,
    fecha DATE NOT NULL,
    hora_comienzo TIME NOT NULL,
    hora_final TIME NOT NULL,
    participantes INTEGER NOT NULL,
    suplentes INTEGER NOT NULL,
    comentarios VARCHAR(100) NOT NULL
);


-- table for suggestions
CREATE TABLE sugerencias (
    id SERIAL PRIMARY KEY,
    descripcion TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
