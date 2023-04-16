create or replace function second_task_tax()
    returns trigger as
$$
    BEGIN
        NEW.price = NEW.price + NEW.price * 0.1;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';


create trigger second_task_tax_trigger
    before insert
    on products
    for each row
    execute procedure second_task_tax();
