CREATE TABLE brands
(
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE products
(
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    code VARCHAR(255) NOT NULL
);

CREATE TABLE prices
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    brand_id   BIGINT       NOT NULL,
    start_date TIMESTAMP    NOT NULL,
    end_date   TIMESTAMP    NOT NULL,
    price_list INTEGER      NOT NULL,
    product_id BIGINT       NOT NULL,
    priority   INTEGER      NOT NULL,
    price      DOUBLE       NOT NULL,
    currency   VARCHAR(255) NOT NULL,
    CONSTRAINT fk_prices_brand FOREIGN KEY (brand_id) REFERENCES brands (id) ON DELETE CASCADE,
    CONSTRAINT fk_prices_product FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE CASCADE
);

INSERT INTO brands (id, name)
VALUES (1, 'ZARA');

INSERT INTO products (id, code)
VALUES (35455, 'PRODUCT_CODE_35455');

INSERT INTO prices (brand_id, start_date, end_date, price_list, product_id, priority, price, currency)
VALUES (1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.50, 'EUR'),
       (1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR'),
       (1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 30.50, 'EUR'),
       (1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR');