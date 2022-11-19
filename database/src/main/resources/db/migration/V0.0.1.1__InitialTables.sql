CREATE TABLE customer(
    id UUID PRIMARY KEY,
    first_name VARCHAR NOT NULL ,
    last_name VARCHAR NOT NULL ,
    email VARCHAR NOT NULL
);

CREATE TYPE product_type AS ENUM ('FOOD', 'DRINK');

CREATE TABLE product(
    id UUID PRIMARY KEY,
    product_type PRODUCT_TYPE not null,
    name VARCHAR NOT NULL UNIQUE,
    description VARCHAR,
    price NUMERIC(12, 2) NOT NULL
);

CREATE INDEX product_product_type_idx on product(product_type);

CREATE TABLE "ORDER"(
    id UUID PRIMARY KEY,
    number BIGSERIAL UNIQUE,
    date TIMESTAMP NOT NULL
);

CREATE TABLE order_item(
    id UUID PRIMARY KEY,
    order_id UUID REFERENCES "ORDER" ON DELETE CASCADE,
    product_id UUID REFERENCES PRODUCT ON DELETE CASCADE,
    amount NUMERIC NOT NULL,
    price NUMERIC(12, 2) NOT NULL,
    UNIQUE(order_id, product_id)
);
