--/* run command from regular terminal: psql <username> -d pets -f schema.sql */
--run command from psql cli: \i /Users/meredithwhite/JavaScript/vmWareAscent/petconnect-search/schema.sql

-- /* Reset */
DROP DATABASE IF EXISTS pet;
CREATE DATABASE pet;

-- ==== THIS IS JUST AN EXAMPLE / CHANGE SCHEMA TO REFLECT CURRENT PROJECT ===
--/* Table 'pets' */
DROP TABLE IF EXISTS pets;

CREATE TABLE pets(
  id serial NOT NULL,
  name varchar(255) NOT NULL,
  type varchar(255) NOT NULL,
  zip varchar(255) NOT NULL,
  age varchar(255) NOT NULL,
  gender varchar(255) NOT NULL,
  breed varchar(255) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO pets(pet_id, owner, name, type, zip, age, gender, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score)
VALUES (DEFAULT, 'Owner', 'Mr. Whiskers', 'cat', '90209', 'young', 'female', 'ragdoll', 10, true, 'cat', 'https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg', 0, false, false, 0);

INSERT INTO pets(pet_id, owner, name, type, zip, age, gender, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score)
VALUES (DEFAULT, 'Owner', 'Beans', 'cat', '90210', 'adult', 'male', 'bengal', 10, true, 'cat', 'https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg', 0, false, false, 0);

INSERT INTO pets(pet_id, owner, name, type, zip, age, gender, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score)
VALUES (DEFAULT, 'Owner', 'Baguera', 'cat', '94704', 'senior', 'female', 'british shorthair', 10, true, 'cat', 'https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg', 0, false, false, 0);

INSERT INTO pets(pet_id, owner, name, type, zip, age, gender, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score)
VALUES (DEFAULT, 'Owner', 'Bitey McNibble', 'cat', '94705', 'young', 'male', 'devon rex', 10, true, 'cat', 'https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg', 0, false, false, 0);

INSERT INTO pets(pet_id, owner, name, type, zip, age, gender, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score)
VALUES (DEFAULT, 'Owner', 'Sam', 'dog', '94710', 'adult', 'male', 'bulldog', 10, true, 'dog', 'https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg', 0, false, false, 0);

INSERT INTO pets(pet_id, owner, name, type, zip, age, gender, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score)
VALUES (DEFAULT, 'Owner', 'Bark Twain', 'dog', '94020', 'senior', 'female', 'golden retriever', 10, true, 'dog', 'https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg', 0, false, false, 0);

INSERT INTO pets(pet_id, owner, name, type, zip, age, gender, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score)
VALUES (DEFAULT, 'Owner', 'Buster', 'dog', '94304', 'young', 'female', 'husky', 10, true, 'dog', 'https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg', 0, false, false, 0);

INSERT INTO pets(pet_id, owner, name, type, zip, age, gender, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score)
VALUES (DEFAULT, 'Owner', 'Chewy', 'dog', '94028', 'adult', 'male', 'corgi', 10, true, 'dog', 'https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg', 0, false, false, 0);
