/*-CREATE TABLE products (
--id SERIAL PRIMARY KEY,
--text VARCHAR(100) NOT NULL,
--done BOOLEAN,
--fridge_id INT,
--CONSTRAINT fk_fridge
--FOREIGN KEY (fridge_id)
--REFERENCES fridges (fridge_id)
--ON DELETE SET NULL
--);

--mysql:
*/
create table products(
id INT primary key AUTO_INCREMENT,
text varchar(100) not null,
done bit,
fridge_id int,
foreign key (fridge_id) references fridges(fridge_id) on delete set null
);