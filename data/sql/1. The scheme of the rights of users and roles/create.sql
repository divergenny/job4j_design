CREATE TABLE roles(
    id serial primary key,
    name varchar(255)
);

CREATE TABLE users(
    id serial primary key,
    name varchar(255),
    role_id int references roles(id)
);

CREATE TABLE rules(
    id serial primary key,
    name varchar(255)
);

CREATE TABLE roles_rules(
    id serial primary key,
    role_id int references roles(id),
    rule_id int references rules(id)
);

CREATE TABLE items(
    id serial primary key,
    name varchar(255),
    user_id int references users(id)
);

CREATE TABLE categories(
    id serial primary key,
    category_name varchar(255),
    item_id int references items(id)
);

CREATE TABLE states(
    id serial primary key,
    active boolean,
    item_id int references items(id)
);

CREATE TABLE attachments(
    id serial primary key,
    attach oid
);

CREATE TABLE comments(
    id serial primary key,
    comment text,
    item_id int references items(id),
    attachment_id references attachments(id)
);
