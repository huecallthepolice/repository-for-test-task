CREATE TABLE IF NOT EXISTS items
(
    id    SERIAL PRIMARY KEY ,
    name  VARCHAR(255) NOT NULL ,
    description VARCHAR(4096) ,
    price DECIMAL(10,3),
    in_stock BOOLEAN DEFAULT FALSE
    );
