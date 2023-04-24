begin transaction isolation level serializable;

insert into products (name, producer, count, price) VALUES ('product_4', 'producer_4', 11, 64);
delete from products where price = 115;
update products set price = 75 where name = 'product_1';
select sum(count) from products;
update products set count = 26 where name = 'product_1';

commit;
