begin transaction;

select * from products;

savepoint first_savepoint;

delete from products;

drop table products;

rollback to first_savepoint;

select * from products;
