DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS customer_order;

CREATE TABLE customer(
    id int NOT NULL AUTO_INCREMENT,
    full_name varchar(255) NOT NULL DEFAULT '',
    email varchar(255) NOT NULL DEFAULT '',
    status varchar(50) NOT NULL DEFAULT 'REGULAR',
    PRIMARY KEY (id)
);

CREATE TABLE customer_order(
    id int NOT NULL AUTO_INCREMENT,
    item_name varchar(255) NOT NULL DEFAULT '',
    item_price DECIMAL(100,2) NOT NULL DEFAULT '',
    customer_id int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

INSERT INTO customer (full_name, email)
VALUES ('A AA', '@@'),('B BB', '@@'),('C CC', '@@'),('D DD', '@@');