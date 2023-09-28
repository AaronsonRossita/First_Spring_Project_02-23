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
VALUES ('A AA', 'a@'),('B BB', 'b@'),('C CC', 'c@'),('D DD', 'd@');

INSERT INTO customer_order (item_name, item_price, customer_id)
VALUES ('sofa', 20, 1),('sofa', 20, 2),('chair', 30, 2),('chair', 30, 3);