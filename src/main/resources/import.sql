CREATE TABLE products (id BIGSERIAL, title VARCHAR(255), cost int, primary key (id));
INSERT INTO products (title, cost) VALUES ('Банан', 50), ('Апельсин', 35), ('Хлеб', 27);
SELECT * FROM products;