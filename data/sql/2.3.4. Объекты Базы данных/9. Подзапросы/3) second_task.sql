insert into orders(amount, customer_id) VALUES(20, 1);
insert into orders(amount, customer_id) VALUES(40, 2);
insert into orders(amount, customer_id) VALUES(70, 3);
insert into orders(amount, customer_id) VALUES(100, 4);

select * from customers c where c.id not in (select customer_id from orders);
