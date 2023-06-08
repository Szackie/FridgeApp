/*--postgre

--CREATE TABLE languages (
--    id SERIAL PRIMARY KEY,
--    welcomeMsg VARCHAR(100) NOT NULL,
--    code VARCHAR(3)
--);

--mysql
*/
create table languages(
id INT primary key AUTO_INCREMENT,
welcomeMsg varchar(100) not null,
code varchar(3)
);