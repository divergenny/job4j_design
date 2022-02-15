create table professors(
    id serial primary key,
    name varchar(255),
    subject varchar(100),
    group_number int,
    admin_number int
);

create table students(
    id serial primary key,
    name varchar(255),
    subject varchar(100),
    in_group_number int,
    under_admin int
);

insert into professors(name, subject, group_number, admin_number) values('Vasiliy Borisovich', 'Math', 1, 1);
insert into professors(name, subject, group_number, admin_number) values('Sergey Petrovich', 'Physics', 2, 2);
insert into professors(name, subject, group_number, admin_number) values('Alexandr Valeryevich', 'English', 3, 3);

insert into students(name, subject, in_group_number, under_admin) values('Anton', 'Math', 1, 1);
insert into students(name, subject, in_group_number, under_admin) values('Leonid', 'Physics', 2, 2);
insert into students(name, subject, in_group_number, under_admin) values('Philip', 'English', 3, 3);
insert into students(name, subject, in_group_number, under_admin) values('Jenya', 'Math', 1, 2);
insert into students(name, subject, in_group_number, under_admin) values('Violetta', 'Physics', 2, 3);
insert into students(name, subject, in_group_number, under_admin) values('Nastya', 'Physics', 3, 1);
insert into students(name, subject, in_group_number, under_admin) values('Anton', 'Physics', 1, 1);
insert into students(name, subject, in_group_number, under_admin) values('Anton', 'English', 1, 1);

1) select s."name", s.subject, p."name" from students as s join professors as p on s.subject = p.subject ORDER BY s."name" ASC
2) select DISTINCT(p."name") as Декан, s."name" as Ученик from students as s join professors as p on s.under_admin = p.admin_number ORDER BY s."name" ASC
3) select  DISTINCT(p."name") as РуководительГруппы, s."name" as УченикГруппы  from students as s join professors as p on s.in_group_number = p.group_number ORDER BY p."name" ASC
