-- 1. Создать таблицы и заполнить их начальными данными
create table departments
(
    id     serial primary key,
    number int
);

create table employers
(
    id            serial primary key,
    name          varchar,
    department_id int references departments (id)
);

insert into departments(number)
values (101);
insert into departments(number)
values (102);
insert into departments(number)
values (103);
insert into departments(number)
values (104);

insert into employers(name, department_id)
values ('Igor', 1);
insert into employers(name, department_id)
values ('Anastasiya', 2);
insert into employers(name, department_id)
values ('Yuliya', 3);
insert into employers(name, department_id)
values ('Alena', null);
insert into employers(name, department_id)
values ('Alisa', null);


-- 2. Выполнить запросы с left, rigth, full, cross соединениями
select d.*
from departments d
         left join employers e on e.department_id = d.id;
select d.*, e.name
from departments d
         right join employers e on e.department_id = d.id;
select d.*, e.name
from departments d
         full join employers e on e.department_id = d.id;
select *
from departments
         cross join employers e;

-- 3. Используя left join найти департаменты, у которых нет работников
select d.*, e.name
from departments d
         left join employers e on e.department_id = d.id
where e.name is null;

-- 4. Используя left и right join написать запросы, которые давали бы одинаковый результат (порядок вывода колонок в эти запросах также должен быть идентичный).
select *
from departments d
         left join employers e on e.department_id = d.id
where e.name is not null;
select *
from departments d
         right join employers e on e.department_id = d.id
where d.id is not null;

-- 5. Создать таблицу teens с атрибутами name, gender и заполнить ее. Используя cross join составить все возможные разнополые пары

create table teens
(
    id     serial primary key,
    name   varchar,
    gender varchar
);

insert into teens(name, gender)
values ('Alena', 'woman');
insert into teens(name, gender)
values ('Lena', 'woman');
insert into teens(name, gender)
values ('Yuliya', 'woman');
insert into teens(name, gender)
values ('Igor', 'man');
insert into teens(name, gender)
values ('Alexandr', 'man');
insert into teens(name, gender)
values ('Evgeniy', 'man');

-- Используя cross join составить все возможные разнополые пары
select w.name                        as woman,
       m.name                        as man,
       (w.name || ' and ' || m.name) as "Possible couples: "
from teens w
         cross join teens m
where w.gender = 'woman'
  AND m.gender = 'man';
