create or replace function first_task_tax()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.1
        where id in (select id from inserted);
        return new;
    END;
$$
LANGUAGE 'plpgsql';


create trigger first_task_tax_trigger
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure first_task_tax();
