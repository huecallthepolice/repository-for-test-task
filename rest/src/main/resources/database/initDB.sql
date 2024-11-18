CREATE TABLE IF NOT EXISTS items
(
    id    SERIAL PRIMARY KEY ,
    name  VARCHAR(255) NOT NULL ,
    description VARCHAR(4096) ,
    price DECIMAL(10,3),
    in_stock BOOLEAN DEFAULT FALSE,
    amount_to_sell int
    );

CREATE TABLE IF NOT EXISTS sold
(
    id    SERIAL PRIMARY KEY ,
    name_of_document  VARCHAR(255) NOT NULL ,
    item_id INT NOT NULL,
    quantity VARCHAR(4096) NOT NULL,
    cost DECIMAL(10,3) NOT NULL,
    FOREIGN KEY (item_id) REFERENCES items(id)

);

CREATE TABLE IF NOT EXISTS delivery
(
    id    SERIAL PRIMARY KEY ,
    name_of_document  VARCHAR(255) NOT NULL ,
    item_id INT NOT NULL,
    quantity VARCHAR(4096) NOT NULL,
    FOREIGN KEY (item_id) REFERENCES items(id)
);