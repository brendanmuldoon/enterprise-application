CREATE TABLE staff (
    id VARCHAR PRIMARY KEY,
    fullname_firstName VARCHAR NOT NULL,
    fullname_surname VARCHAR NOT NULL,
    address_housenumber VARCHAR NOT NULL,
    address_streetname VARCHAR NOT NULL,
    address_postcode VARCHAR NOT NULL,
    role VARCHAR NOT NULL,
    securitycredentials_username VARCHAR NOT NULL,
    securitycedentials_password VARCHAR NOT NULL
);

CREATE TABLE staff_skills(
    id int AUTO_INCREMENT PRIMARY KEY,
    skill_id VARCHAR NOT NULL,
    strength_of_skill VARCHAR NOT NULL,
    expiry DATE NOT NULL,
    staff_id VARCHAR NOT NULL,
    FOREIGN KEY (staff_id) REFERENCES staff(id)
);