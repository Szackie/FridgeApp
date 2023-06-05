CREATE TABLE products (
id SERIAL PRIMARY KEY,
text VARCHAR(100) NOT NULL,
done BOOLEAN,
fridge_id INT,
CONSTRAINT fk_fridge
FOREIGN KEY (fridge_id)
REFERENCES fridges (fridge_id)
ON DELETE SET NULL
);