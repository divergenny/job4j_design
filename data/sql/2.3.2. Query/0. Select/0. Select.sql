create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date) values('Fish', 7, '1991.01.01');
insert into fauna(name, avg_age, discovery_date) values('Bear', 20, '2000.01.01');
insert into fauna(name, avg_age, discovery_date) values('Cat', 10, '2002.02.02');
insert into fauna(name, avg_age, discovery_date) values('Dog', 10, '2004.04.04');
insert into fauna(name, avg_age, discovery_date) values('Dog', 10, '2004.04.04');
insert into fauna(name, avg_age, discovery_date) values('Parrot', 40, '1920.04.04');
insert into fauna(name, avg_age, discovery_date) values('Crocodile', 50, null);
insert into fauna(name, avg_age, discovery_date) values('Crane', 10001, null);


select * from fauna f where f.name LIKE '%fish%';
select * from fauna f where f.avg_age between 10000 AND 21000;
select * from fauna f where f.discovery_date is null;
select * from fauna f where f.discovery_date < '01.01.1950';
