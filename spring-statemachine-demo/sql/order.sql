DROP TABLE IF EXISTS orders;
CREATE TABLE orders (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(100) NOT NULL,
    state varchar(20) NOT NULL,
    created_at timestamp NOT NULL DEFAULT '2026-01-01 00:00:00',
    updated_at timestamp NOT NULL DEFAULT '2026-01-01 00:00:00',
    PRIMARY KEY (id)
);