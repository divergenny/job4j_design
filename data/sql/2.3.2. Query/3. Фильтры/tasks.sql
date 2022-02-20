-- 1. Написать запрос получение всех продуктов с типом "СЫР"
select p.*
from product p
join type t on p.type_id=t.id
where t.name = 'СЫР';

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженое"
select * from product
where name LIKE '%мороженое%';

-- 3. Написать запрос, который выводит все продукты, срок годности которых уже истек.
select * from product p
where p.expired_date < current_date

-- 4. Написать запрос, который выводит самый дорогой продукт.
select p.name from product p
where p.price = (select max(price)
				 from product)

-- 5. Написать запрос, который выводит для каждого типа количество продуктов к нему принадлежащих.
-- В виде имя_типа, количество.
select t.name as TypeOfProduct, COUNT(p.id) as Quantity
from product p join type t on p.type_id = t.id
group by t.name

-- 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select p.*
from product p join type t on p.type_id = t.id
where t.name IN('СЫР', 'МОЛОКО')

-- 7. Task
select t.name as TypeOfProduct, COUNT(p.id) as Quantity
from product p join type t on p.type_id = t.id
group by t.name
having COUNT(p.id) < 10

-- 8. Вывести все продукты и их тип.
select p.*, t.name
from product p join type t on p.type_id = t.id
