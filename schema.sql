--/* run command from regular terminal: psql <username> -d pets -f schema.sql */
--run command from psql cli: \i /Users/meredithwhite/JavaScript/vmWareAscent/petconnect-search/schema.sql

-- /* Reset */
DROP DATABASE IF EXISTS petsProfiles;
CREATE DATABASE petsProfiles;

-- ==== THIS IS JUST AN EXAMPLE / CHANGE SCHEMA TO REFLECT CURRENT PROJECT ===
--/* Table 'pets' */
DROP TABLE IF EXISTS pets;

CREATE TABLE pets(
  pet_id serial NOT NULL,
  owner varchar(255) NOT NULL,
  name varchar(255) NOT NULL,
  type varchar(255) NOT NULL,
  city varchar(255) NOT NULL,
  state varchar(255) NOT NULL,
  zip varchar(255) NOT NULL,
  age varchar(255) NOT NULL,
  sex varchar(255) NOT NULL,
  breed varchar(255) NOT NULL,
  species varchar(255) NOT NULL,
  weight double precision NOT NULL,
  reproductive_status boolean NOT NULL,
  description varchar(255) NOT NULL,
  cover_photo varchar(255) NOT NULL,
  favorite_count int NOT NULL,
  reported boolean NOT NULL ,
  adopted boolean NOT NULL,
  score int NOT NULL,
  date_posted TIMESTAMP NOT NULL,
  PRIMARY KEY(id)
);


INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Mr. Whiskers', 'cat', '90209', 'young', 'female', 'ragdoll', 10, true, 'cat', 'https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Beans', 'cat', '90210', 'adult', 'male', 'bengal', 10, true, 'cat', 'https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Baguera', 'cat', '94704', 'senior', 'female', 'british shorthair', 10, true, 'cat', 'https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Bitey McNibble', 'cat', '94705', 'young', 'male', 'devon rex', 10, true, 'cat', 'https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Sam', 'dog', '94710', 'adult', 'male', 'bulldog', 10, true, 'dog', 'https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Bark Twain', 'dog', '94020', 'senior', 'female', 'golden retriever', 10, true, 'dog', 'https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Buster', 'dog', '94304', 'young', 'female', 'husky', 10, true, 'dog', 'https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Chewy', 'dog', '94028', 'adult', 'male', 'corgi', 10, true, 'dog', 'https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Charles', 'iguana', '94328', 'adult', 'male', 'fire dragon', 10, true, 'iguana', 'https://static.inaturalist.org/photos/95742200/large.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);
