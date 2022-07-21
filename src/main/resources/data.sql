INSERT INTO employee (id,
                   fullname_firstname,
                   fullname_surname,
                   address_housenumber,
                   address_streetname,
                   address_postcode,
                   role,
                   securitycredentials_username,
                   securitycedentials_password)
VALUES ('123e4567-e89b-12d3-a456-426614174000', 'Brendan', 'Muldoon', '5', 'Foxton Place', 'BT365FS', 'Manager', 'brendy', 'password'),
 ('5199227a-0845-11ed-861d-0242ac120002', 'Emma', 'Muldoon', '5', 'Foxton Place', 'BT365FS', 'Staff', 'emma', 'password'),
 ('5f52c9e8-0845-11ed-861d-0242ac120002', 'Billy', 'Bob', '56', 'Rad Town', 'BT124FT', 'Staff', 'billybob', 'password');




INSERT INTO staff_skills(skill_id, strength_of_skill, expiry, staff_id)
VALUES ('1111-1111-1111-1111', 'Basic', '2022-12-31', '123e4567-e89b-12d3-a456-426614174000'),
       ('2222-2222-2222-2222', 'Intermediate', '2022-12-31', '123e4567-e89b-12d3-a456-426614174000'),
       ('1111-2222-3333-4444', 'Advanced', '2022-12-31', '123e4567-e89b-12d3-a456-426614174000'),
       ('1111-1111-1111-1111', 'Basic', '2022-12-31', '5199227a-0845-11ed-861d-0242ac120002'),
       ('2222-2222-2222-2222', 'Intermediate', '2022-12-31', '5199227a-0845-11ed-861d-0242ac120002'),
       ('1111-2222-3333-4444', 'Advanced', '2022-12-31', '5f52c9e8-0845-11ed-861d-0242ac120002');
create sequence skills_sequence_id start with (select max(id) + 1 from staff_skills);

INSERT INTO manager_team(staff_id, manager_id)
VALUES ('5199227a-0845-11ed-861d-0242ac120002', '123e4567-e89b-12d3-a456-426614174000'),
       ('5f52c9e8-0845-11ed-861d-0242ac120002', '123e4567-e89b-12d3-a456-426614174000');
create sequence team_sequence_id start with (select max(id) + 1 from manager_team);

