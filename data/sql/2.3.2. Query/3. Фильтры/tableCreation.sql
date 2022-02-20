create table type(
    id serial primary key,
    name varchar
);

create table product(
 id serial primary key,
 name varchar,
 type_id int references type(id),
 expired_date date,
 price numeric
);
