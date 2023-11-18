-- 新建表
CREATE TABLE product (
    id int PRIMARY KEY,
    price numeric(20,8) NOT NULL
);

-- 插入值
INSERT INTO product VALUES (1, 20000);