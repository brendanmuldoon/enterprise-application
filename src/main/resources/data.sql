INSERT INTO staff (id,
                   fullname_firstname,
                   fullname_surname,
                   address_housenumber,
                   address_streetname,
                   address_postcode,
                   role,
                   securitycredentials_username,
                   securitycedentials_password)
VALUES ('0000', 'Brendan', 'Muldoon', '5', 'Foxton Place', 'BT365FS', 1, 'brendy', 'password');

INSERT INTO staff_skills(id, skill_id, strength_of_skill, expiry, staff_id)
VALUES ('1111-1111-1111-1111', '1234-1234-1234-1234', 1, '2022-12-31', '0000'),
       ('2222-2222-2222-2222', '4321-4321-4321-4321', 2, '2022-12-31', '0000'),
       ('3333-3333-3333-3333', '1111-2222-3333-4444', 3, '2022-12-31', '0000');

create sequence skills_sequence_id start with (select max(id) + 1 from staff_skills);