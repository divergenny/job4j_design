create table history_of_price (
    id serial primary key,
    name varchar(50),
    price integer,
    date timestamp
);


create or replace function third_task_save_info()
    returns trigger as
$$
    BEGIN
        insert into history_of_price (name, price, date)
        VALUES (NEW.producer, NEW.price, current_date);
        return NEW;
    END
$$
LANGUAGE 'plpgsql';


create trigger third_task_save_info_trigger
    before insert
    on products
    for each row
    execute procedure third_task_save_info();
