CREATE TABLE tb_product_withdrawals (
  id SERIAL PRIMARY KEY,
  date TIMESTAMP,
  quantity INT,
  id_product INT REFERENCES tb_product(id),
  id_user INT REFERENCES tb_user(id)
);
