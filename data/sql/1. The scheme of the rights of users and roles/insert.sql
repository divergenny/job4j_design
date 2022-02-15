insert into roles(name) values ('admin');
insert into roles(name) values ('user');

insert into users(name, role_id) values ('Jamshid', 1);
insert into users(name, role_id) values ('Bakhrom', 2);

insert into rules(name) values('Create');
insert into rules(name) values('Update');
insert into rules(name) values('Delete');
insert into rules(name) values('Read');

insert into roles_rules(role_id, rule_id) values(1, 1);
insert into roles_rules(role_id, rule_id) values(1, 2);
insert into roles_rules(role_id, rule_id) values(1, 3);
insert into roles_rules(role_id, rule_id) values(1, 4);
insert into roles_rules(role_id, rule_id) values(2, 4);

insert into items(name, user_id) values('Arsenal Champion', 2);
insert into items(name, user_id) values('TASS VISION', 1);

insert into categories(category_name, item_id) values('Sport', 1);
insert into categories(category_name, item_id) values('Information Technologies', 2);

insert into states(active, item_id) values(true, 2);
insert into states(active, item_id) values(false, 2);

insert into attachments(attach_path) values('C:\test\arsenal.png');
insert into attachments(attach_path) values('C:\test\tass.png');

insert into comments(comment, item_id, attachment_id) values('Arsenal mush be Champion on 2022!', 1, 1);
insert into comments(comment, item_id, attachment_id) values('Arsenal mush be Champion on 2022!', 2, 2);
