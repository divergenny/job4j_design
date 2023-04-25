begin transaction;

insert into products (name, producer, count, price) VALUES ('product_4', 'producer_4', 11, 64);

commit transaction;

select * from products;
