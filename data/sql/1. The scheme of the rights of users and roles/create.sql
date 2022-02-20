create TABLE roles(
    id serial primary key,
    name varchar(255)
);

create TABLE users(
    id serial primary key,
    name varchar(255),
    role_id int references roles(id)
);

create TABLE rules(
    id serial primary key,
    name varchar(255)
);

create TABLE roles_rules(
    id serial primary key,
    role_id int references roles(id),
    rule_id int references rules(id)
);


create TABLE categories(
    id serial primary key,
    category_name varchar(255)
);

create TABLE states(
    id serial primary key,
    active boolean
);

create TABLE items(
    id serial primary key,
    name varchar(255),
    user_id int references users(id),
    category_id int references categories(id),
    state_id int references states(id)
);


create TABLE attachments(
    id serial primary key,
    attach_path text,
    item_id int references items(id)
);

create TABLE comments(
    id serial primary key,
    comment text,
    item_id int references items(id)
);
