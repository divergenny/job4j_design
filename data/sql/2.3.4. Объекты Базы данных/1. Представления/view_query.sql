-- Список студентов, у которых находится 2 и более книг и заказ в активном состоянии

create view show_students_with_2_or_more_active_books
    as select s.name as Студент, count(s.name) as "Количество книг" from students as s
                                                  join orders o on s.id = o.student_id
                                                  join books b on o.book_id = b.id
                                                  join authors a on b.author_id = a.id
        group by (s.name, o.active) having (o.active = true and count(s.name) >= 2);

select * from show_students_with_2_or_more_active_books;
