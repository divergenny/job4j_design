create or replace procedure p_delete_record_when_no_product(u_id integer)
language 'plpgsql'
as
$$
    DECLARE
        v_count integer;
    BEGIN
        select into v_count count from products where id = u_id;
        if v_count = 0 THEN
            delete from products where id = u_id;
        end if;
    END
$$;


call p_delete_record_when_no_product(1);


create or replace function f_delete_record_when_no_product(i_producer varchar)
returns void
language 'plpgsql'
as
$$
    begin
        delete from products where i_producer IN (select producer from products where count = 0) AND id IN (select id from products where count = 0);
    end;
$$;


select f_delete_record_when_no_product('Dobriy');
