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
VALUES ('0f6b61ae-09cd-11ed-861d-0242ac120002', 'Basic', '2022-12-31', '123e4567-e89b-12d3-a456-426614174000'),
       ('2448e8f8-09cd-11ed-861d-0242ac120002', 'Intermediate', '2022-12-31', '123e4567-e89b-12d3-a456-426614174000'),
       ('2e661c48-09cd-11ed-861d-0242ac120002', 'Advanced', '2022-12-31', '123e4567-e89b-12d3-a456-426614174000'),
       ('0f6b61ae-09cd-11ed-861d-0242ac120002', 'Basic', '2022-12-31', '5199227a-0845-11ed-861d-0242ac120002'),
       ('2448e8f8-09cd-11ed-861d-0242ac120002', 'Intermediate', '2022-12-31', '5199227a-0845-11ed-861d-0242ac120002'),
       ('2e661c48-09cd-11ed-861d-0242ac120002', 'Intermediate', '2022-12-31', '5199227a-0845-11ed-861d-0242ac120002'),
       ('2e661c48-09cd-11ed-861d-0242ac120002', 'Advanced', '2022-12-31', '5f52c9e8-0845-11ed-861d-0242ac120002');
create sequence skills_sequence_id start with (select max(id) + 1 from staff_skills);

INSERT INTO manager_team(staff_id, manager_id)
VALUES ('5199227a-0845-11ed-861d-0242ac120002', '123e4567-e89b-12d3-a456-426614174000'),
       ('5f52c9e8-0845-11ed-861d-0242ac120002', '123e4567-e89b-12d3-a456-426614174000');
create sequence team_sequence_id start with (select max(id) + 1 from manager_team);


