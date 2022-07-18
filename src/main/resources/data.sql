INSERT INTO staff (id,
                   fullname_firstname,
                   fullname_surname,
                   address_housenumber,
                   address_streetname,
                   address_postcode,
                   role,
                   securitycredentials_username,
                   securitycedentials_password)
VALUES ('123e4567-e89b-12d3-a456-426614174000', 'Brendan', 'Muldoon', '5', 'Foxton Place', 'BT365FS', 'Staff', 'brendy', 'password');

INSERT INTO staff_skills(skill_id, strength_of_skill, expiry, staff_id)
VALUES ('1111-1111-1111-1111', 'Basic', '2022-12-31', '123e4567-e89b-12d3-a456-426614174000'),
       ('2222-2222-2222-2222', 'Intermediate', '2022-12-31', '123e4567-e89b-12d3-a456-426614174000'),
       ('1111-2222-3333-4444', 'Advanced', '2022-12-31', '123e4567-e89b-12d3-a456-426614174000');

create sequence skills_sequence_id start with (select max(id) + 1 from staff_skills);