-- One to Many

create table subjects(
    id serial primary key,
    name varchar(255)
);

create table students(
    id serial primary key,
    name varchar(255),
    subject_id int references subjects(id)
);

-- One to One

create table id_cards(
    id serial primary key,
    number int
);

create table students(
    id serial primary key,
    name varchar(255),
    card_id int references id_cards(id) unique
);

-- Many to Many

create table professors(
    id serial primary key,
    name varchar(255)
);

create table subjects(
    id serial primary key,
    name varchar(255)
);

create table students(
    id serial primary key,
    name varchar(255),
    professor_id int references professors(id),
    subjects int references subjects(id)
);
