/*--CREATE TABLE fridges (
--fridge_id SERIAL PRIMARY KEY,
--name VARCHAR(100) NOT NULL
--);

--mysql
*/
create table fridges(
    fridge_id INT primary key AUTO_INCREMENT,
    name varchar(100) not null
);