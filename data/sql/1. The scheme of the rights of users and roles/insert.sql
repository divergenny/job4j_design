insert into roles(name)
values ('admin');
insert into roles(name)
values ('user');

insert into users(name, role_id)
values ('Jamshid', 1);
insert into users(name, role_id)
values ('Bakhrom', 2);

insert into rules(name)
values('Create');
insert into rules(name)
values('Update');
insert into rules(name)
values('Delete');
insert into rules(name)
values('Read');

insert into roles_rules(role_id, rule_id)
values(1, 1);
insert into roles_rules(role_id, rule_id)
values(1, 2);
insert into roles_rules(role_id, rule_id)
values(1, 3);
insert into roles_rules(role_id, rule_id)
values(1, 4);
insert into roles_rules(role_id, rule_id)
values(2, 4);

insert into categories(category_name)
values('Sport');
insert into categories(category_name)
values('Information Technologies');

insert into states(active)
values(true);
insert into states(active)
values(false);

insert into items(name, user_id, category_id, state_id)
values('Arsenal Champion', 2, 1, 2);
insert into items(name, user_id, category_id, state_id)
values('TASS VISION', 1, 2, 1);

insert into attachments(attach_path, item_id)
values('C:\test\arsenal.png', 1);
insert into attachments(attach_path, item_id)
values('C:\test\tass.png', 2);

insert into comments(comment, item_id)
values('Arsenal mush be Champion on 2022!', 1);
insert into comments(comment, item_id)
values('Tass Vision need more projects!', 2);
