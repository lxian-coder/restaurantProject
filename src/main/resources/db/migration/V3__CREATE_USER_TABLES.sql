
DROP TABLE IF EXISTS "users";
CREATE TABLE users (
    id SERIAL primary key,
    userName varchar(30),
    encoded_password varchar (100),
    password_hint varchar (100)
);

DROP TABLE IF EXISTS "authorities";
CREATE TABLE authorities (
    id SERIAL primary key,
    permission varchar (30)
);

DROP Table IF EXISTS "users_authorities";
CREATE TABLE users_authorities(
    user_id int references users(id),
    authority_id int references authorities (id),
    primary key (user_id,authority_id)
);

