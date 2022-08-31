/* run command: psql <username> - h 127.0.0.1 - d petsProfiles - f schema.sql */

-- /* Reset */
DROP DATABASE pets IF EXISTS;
CREATE petsProfiles;


-- ==== THIS IS JUST AN EXAMPLE / CHANGE SCHEMA TO REFLECT CURRENT PROJECT ===
/* Table 'pets' */
CREATE TABLE pets(
  id serial NOT NULL,
  name varchar(255) NOT NULL,
  type varchar(255) NOT NULL,
  PRIMARY KEY(id)
);

