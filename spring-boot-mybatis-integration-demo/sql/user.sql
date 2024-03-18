CREATE DATABASE test DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS user;
CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    role ENUM('ADMIN', 'EDITOR', 'VIEWER') DEFAULT 'VIEWER',
    description VARCHAR(300) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT '2024-01-01 00:00:00',
    updated_at TIMESTAMP NOT NULL DEFAULT '2024-01-01 00:00:00',
    deleted BOOLEAN DEFAULT FALSE
);

INSERT INTO user(email, name, role, description, created_at, updated_at, deleted) VALUES
    ('larry@larry.com', 'Larry', 'ADMIN', 'I am Larry', '2024-01-01 08:00:00', '2024-01-01 08:00:00', false),
    ('jacky@jacky.com', 'Jacky', 'EDITOR', 'I am Jacky', '2024-02-01 08:00:00', '2024-02-01 08:00:00', false),
    ('lucy@lucy.com', 'Lucy', 'VIEWER', 'I am Lucy', '2024-03-01 08:00:00', '2024-03-01 08:00:00', false);