CREATE DATABASE test DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS actor;
CREATE TABLE actor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    nationality VARCHAR(100) NOT NULL,
    year_of_birth INT NOT NULL
);

DROP TABLE IF EXISTS movie;
CREATE TABLE movie (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    released_at INT NOT NULL
);

DROP TABLE IF EXISTS actor_movie;
CREATE TABLE actor_movie (
    actor_id BIGINT NOT NULL,
    movie_id BIGINT NOT NULL,
    role VARCHAR(100) NOT NULL,
    PRIMARY KEY (actor_id, movie_id)
);

INSERT INTO actor(name, nationality, year_of_birth) VALUES
    ('吴京', '中国', 1974),
    ('卢靖姗', '中国', 1985);

INSERT INTO movie(name, released_at) VALUES
    ('战狼 Ⅱ', 2017),
    ('太极宗师', 1998),
    ('流浪地球 Ⅱ', 2023),
    ('我和我的家乡', 2020);

INSERT INTO actor_movie(actor_id, movie_id, role) VALUES
    (1, 1, '冷峰'),
    (1, 2, '杨昱乾'),
    (1, 3, '刘培强'),
    (2, 1, 'Rachel'),
    (2, 4, 'EMMA MEIER');