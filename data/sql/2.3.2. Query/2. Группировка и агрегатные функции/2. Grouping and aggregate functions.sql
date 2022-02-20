-- 2. Заполнить таблицы данными.
insert into devices(name, price)
values('XIAOMI POCO X3 PRO 8/256', 280);
insert into devices(name, price)
values('XIAOMI Redmi 9C 3/64', 180);
insert into devices(name, price)
values('XIAOMI Redmi NOTE 11 3/64', 220);

insert into people(name)
values('Evgeniy');
insert into people(name)
values('Mariya');
insert into people(name)
values('Alexandr');

insert into devices_people(device_id, people_id)
values(1, 1);
insert into devices_people(device_id, people_id)
values(2, 2);
insert into devices_people(device_id, people_id)
values(3, 3);
insert into devices_people(device_id, people_id)
values(1, 3);

-- 3. Используя агрегатные функции вывести среднюю цену устройств.
select avg(d.price) as average_price_of_devices
from devices d;

-- 4. Используя группировку вывести для каждого человека среднюю цену его устройств.
select p.name,  avg(d.price) as average_price
from people p
join devices_people dp on p.id = dp.people_id
join devices d on d.id = dp.device_id
GROUP BY p.name;

-- 5. Дополнить запрос п.4. условием, что средняя стоимость устройств должна быть больше 5000.
select p.name,  avg(d.price) as average_price
from people p
join devices_people dp on p.id = dp.people_id
join devices d on d.id = dp.device_id
GROUP BY p.name
HAVING avg(d.price) > 5000;
