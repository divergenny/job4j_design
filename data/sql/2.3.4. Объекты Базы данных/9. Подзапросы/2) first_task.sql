insert into customers (first_name, last_name, age, country) VALUES ('Keith', 'Bernard', 27, 'Spain');
insert into customers (first_name, last_name, age, country) VALUES ('Sydnee', 'Jimenez', 44, 'Brazil');
insert into customers (first_name, last_name, age, country) VALUES ('Rudyard', 'Palmer', 55, 'Singapore');
insert into customers (first_name, last_name, age, country) VALUES ('Pearl', 'Hopper', 32, 'South Korea');
insert into customers (first_name, last_name, age, country) VALUES ('Александр ', 'Лукашенко', 68, 'Беларусь');
insert into customers (first_name, last_name, age, country) VALUES ('Валерий ', 'Михалков', 27, 'Россия');

select * from customers WHERE age = (select min(age) from customers);
