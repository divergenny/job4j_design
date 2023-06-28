-- First task: выведите названия всех фильмов, которые сняты по книге.
select name from movie
INTERSECT
select title from author;

-- Second task: выведите все названия книг, у которых нет экранизации.
select title from book
EXCEPT
select name from movie;

-- Third task: выведите все уникальные названия произведений из таблиц movie и book (т.е фильмы, которые сняты не по книге, и книги без экранизации).
(select title from book
EXCEPT
select name from movie)
UNION
(select name from movie
EXCEPT
select title from book);
