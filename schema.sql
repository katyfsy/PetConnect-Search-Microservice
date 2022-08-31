--/* run command from regular terminal: psql <username> -d pets -f schema.sql */
--run command from psql cli: \i /Users/meredithwhite/JavaScript/vmWareAscent/petconnect-search/schema.sql

-- /* Reset */
DROP DATABASE IF EXISTS petsProfiles;
CREATE DATABASE petsProfiles;

-- ==== THIS IS JUST AN EXAMPLE / CHANGE SCHEMA TO REFLECT CURRENT PROJECT ===
--/* Table 'pets' */
DROP TABLE IF EXISTS pets;

CREATE TABLE pets(
  id serial NOT NULL,
  name varchar(255) NOT NULL,
  type varchar(255) NOT NULL,
  zip varchar(255) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO pets(id, name, type, zip)
VALUES (DEFAULT, 'Mr. Whiskers', 'cat', '98745');

INSERT INTO pets(id, name, type, zip)
VALUES (DEFAULT, 'Beans', 'cat', '95745');

INSERT INTO pets(id, name, type, zip)
VALUES (DEFAULT, 'Baguera', 'cat', '88745');

INSERT INTO pets(id, name, type, zip)
VALUES (DEFAULT, 'Bitey McNibble', 'cat', '78745');


INSERT INTO pets(id, name, type, zip)
VALUES (DEFAULT, 'Sam', 'dog', '98745');

INSERT INTO pets(id, name, type, zip)
VALUES (DEFAULT, 'Bark Twain', 'dog', '68745');

INSERT INTO pets(id, name, type, zip)
VALUES (DEFAULT, 'Buster', 'dog', '58745');

INSERT INTO pets(id, name, type, zip)
VALUES (DEFAULT, 'Chewy', 'dog', '48745');
