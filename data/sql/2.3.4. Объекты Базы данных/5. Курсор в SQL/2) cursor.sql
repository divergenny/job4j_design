BEGIN;
DECLARE
    cursor_products scroll cursor for
                            select * from products;

FETCH LAST FROM cursor_products;

MOVE BACKWARD 5 FROM cursor_products;

MOVE BACKWARD 8 FROM cursor_products;

MOVE BACKWARD 5 FROM cursor_products;

MOVE BACKWARD 1 FROM cursor_products;

FETCH NEXT FROM cursor_products;

CLOSE cursor_products;

COMMIT;
