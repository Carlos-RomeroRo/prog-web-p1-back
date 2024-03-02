-- Usuarios
INSERT INTO
    usuarios (
        username,
        email,
        nombre,
        apellidos,
        edad,
        password,
        rep_password,
        enabled,
        foto,
        rol,
        created_at
    )
VALUES
    (
        'usuario1',
        'usuario1@example.com',
        'Usuario',
        'Uno',
        30,
        'contrasena1',
        'contrasena1',
        true,
        'foto1.jpg',
        'usuario',
        CURRENT_TIMESTAMP
    ),
    (
        'usuario2',
        'usuario2@example.com',
        'Usuario',
        'Dos',
        25,
        'contrasena2',
        'contrasena2',
        true,
        'foto2.jpg',
        'usuario',
        CURRENT_TIMESTAMP
    ),
    (
        'usuario3',
        'usuario3@example.com',
        'Usuario',
        'Tres',
        35,
        'contrasena3',
        'contrasena3',
        true,
        'foto3.jpg',
        'usuario',
        CURRENT_TIMESTAMP
    );

-- Mensajes
INSERT INTO
    mensajes (
        creador_email,
        destinatario_email,
        created_at,
        contenido
    )
VALUES
    (
        'usuario1@example.com',
        'usuario2@example.com',
        CURRENT_TIMESTAMP,
        'Hola, ¿cómo estás?'
    ),
    (
        'usuario2@example.com',
        'usuario1@example.com',
        CURRENT_TIMESTAMP,
        'Hola, estoy bien, gracias.'
    ),
    (
        'usuario3@example.com',
        'usuario1@example.com',
        CURRENT_TIMESTAMP,
        'Hola, ¿podemos reunirnos mañana?'
    );

-- Partidas
INSERT INTO
    partidas (
        creador_email,
        deporte,
        ciudad,
        provincia,
        fecha,
        hora_comienzo,
        hora_final,
        participantes,
        suplentes,
        comentarios
    )
VALUES
    (
        'usuario1@example.com',
        'Fútbol',
        'Ciudad 1',
        'Provincia 1',
        '2024-03-01',
        '18:00:00',
        '20:00:00',
        10,
        2,
        'Partida amistosa'
    ),
    (
        'usuario2@example.com',
        'Baloncesto',
        'Ciudad 2',
        'Provincia 2',
        '2024-03-02',
        '17:30:00',
        '19:30:00',
        8,
        1,
        'Entrenamiento'
    ),
    (
        'usuario3@example.com',
        'Tenis',
        'Ciudad 3',
        'Provincia 3',
        '2024-03-03',
        '16:00:00',
        '18:00:00',
        4,
        0,
        'Partida de práctica'
    );

-- Sugerencias
INSERT INTO
    sugerencias (descripcion, created_at)
VALUES
    ('Sugerencia 1', CURRENT_TIMESTAMP),
    ('Sugerencia 2', CURRENT_TIMESTAMP),
    ('Sugerencia 3', CURRENT_TIMESTAMP);