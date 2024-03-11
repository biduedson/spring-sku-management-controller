CREATE TABLE advertised_products (
  id SERIAL PRIMARY KEY,
  product_id INT REFERENCES tb_product(id),
  product_name VARCHAR(255),
  advertise_link VARCHAR(255),
  publish_date TIMESTAMP,
  platform_id INT REFERENCES tb_platform(id)
);