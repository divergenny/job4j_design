create table workers(
	id serial primary key,
	name varchar(255),
	married boolean,
	birthday date
);

insert into workers(name, married, birthday) 
values('Vlad', false, '20.01.1997');

update workers set birthday = '22.07.1997';

delete from workers;