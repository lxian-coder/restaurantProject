DO
$do$
DECLARE
r restaurant.menu%rowtype;
BEGIN
FOR r IN
SELECT * FROM restaurant.menu
    LOOP
UPDATE restaurant.menu
SET index = r.id -1
WHERE id = r.id;
END LOOP;
END

$do$


