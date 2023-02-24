create table products(
id INT primary key AUTO_INCREMENT,
text varchar(100) not null,
done bit,
fridge_id int,
foreign key (fridge_id) references fridges(fridge_id) on delete cascade
);