-- First part
create table bodies_of_car
(
    id   serial primary key,
    type varchar
);
create table engines
(
    id   serial primary key,
    type varchar
);
create table gearboxes
(
    id   serial primary key,
    type varchar
);
create table car
(
    id             serial primary key,
    model          varchar,
    body_of_car_id int references bodies_of_car (id),
    engine_id      int references engines (id),
    gearbox_id     int references gearboxes (id)
);

insert into bodies_of_car(type)
values ('Sedan');
insert into bodies_of_car(type)
values ('Hatchback');
insert into bodies_of_car(type)
values ('Liftback');
insert into bodies_of_car(type)
values ('Limousine');
insert into bodies_of_car(type)
values ('SUV');
insert into bodies_of_car(type)
values ('Crossover');
insert into bodies_of_car(type)
values ('Stretch');

insert into engines(type)
values ('Petrol engine');
insert into engines(type)
values ('Diesel engine');
insert into engines(type)
values ('Gas engine');
insert into engines(type)
values ('Electric motor');

insert into gearboxes(type)
values ('Manual transmission');
insert into gearboxes(type)
values ('Semi-automatic transmission');
insert into gearboxes(type)
values ('Automatic transmission');

insert into car(model, body_of_car_id, engine_id, gearbox_id)
values ('LADA KALINA', 1, 1, 3);
insert into car(model, body_of_car_id, engine_id, gearbox_id)
values ('AUDI S3', 2, 1, 3);
insert into car(model, body_of_car_id, engine_id, gearbox_id)
values ('CHEVROLET NEXIA 3', 1, 3, 2);
insert into car(model, body_of_car_id, engine_id, gearbox_id)
values ('Tesla Model 3', 1, 4, 3);

-- 2. Создать SQL запросы:

-- 1) Вывести список всех машин и все привязанные к ним детали.
select c.model, bof.type as Кузов, e.type as Двигатель, g.type as "Коробка передач"
from car c
         join bodies_of_car bof on c.body_of_car_id = bof.id
         join engines e on c.engine_id = e.id
         join gearboxes g on c.gearbox_id = g.id

-- 2) Вывести отдельно детали (1 деталь - 1 запрос),
-- которые не используются НИ в одной машине, кузова, двигатели, коробки передач.

-- Для кузова
select bof.type as "Not using Bodies of car"
from car c
         right join bodies_of_car bof on c.body_of_car_id = bof.id
where c.model is null

-- Для двигателей
select e.type as "Not using engines"
from car c
         right join engines e on c.engine_id = e.id
where c.model is null

-- Для коробки передач
select g.type as "Not using gearboxes"
from car c
         right join gearboxes g on c.gearbox_id = g.id
where c.model is null
