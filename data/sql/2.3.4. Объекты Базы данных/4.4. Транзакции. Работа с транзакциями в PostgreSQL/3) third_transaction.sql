begin transaction;

select * from products;

savepoint first_savepoint;

delete from products;

select * from products;

savepoint second_savepoint;

insert into products (name, producer, count, price) VALUES ('product_5', 'producer_5', 13, 78);

insert into products (name, producer, count, price) VALUES ('product_6', 'producer_8', 14, 86);

select * from products;

rollback to second_savepoint;

select * from products;

rollback to first_savepoint;

select * from products;

insert into products (name, producer, count, price) VALUES ('product_5', 'producer_5', 16, 82);

rollback to second_savepoint;

commit transaction;

select * from products;
