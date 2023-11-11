CREATE TABLE products
(
    id          serial PRIMARY KEY,
    name        text    NOT NULL,
    quantity    numeric NOT NULL,
    description text    NOT NULL,
    expiry_date date    NOT NULL
);

CREATE INDEX idx_products ON products (id);
