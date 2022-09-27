--/* run command from regular terminal: psql <username> -d pets -f schema.sql */
--run command from psql cli: \i /Users/meredithwhite/JavaScript/vmWareAscent/petconnect-search/schema.sql

-- /* Reset */
DROP DATABASE IF EXISTS petsProfiles;
CREATE DATABASE petsProfiles;

-- ==== THIS IS JUST AN EXAMPLE / CHANGE SCHEMA TO REFLECT CURRENT PROJECT ===
--/* Table 'pets' */
DROP TABLE IF EXISTS pets CASCADE;

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
  reproductive_status varchar(255) NOT NULL,
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
VALUES (DEFAULT, 'Owner', 'Mr. Whiskers', 'cat', '90209', 'young', 'female', 'ragdoll', 'small', "reproductive", 'cat', 'https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Beans', 'cat', '90210', 'adult', 'male', 'bengal', 'small', "reproductive", 'cat', 'https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Baguera', 'cat', '94704', 'senior', 'female', 'british shorthair', 'small', "reproductive", 'cat', 'https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Bitey McNibble', 'cat', '94705', 'young', 'male', 'devon rex', 'small', "reproductive", 'cat', 'https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Sam', 'dog', '94710', 'adult', 'male', 'bulldog', 'small', "reproductive", 'dog', 'https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Bark Twain', 'dog', '94020', 'senior', 'female', 'golden retriever', 'small', "reproductive", 'dog', 'https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Buster', 'dog', '94304', 'young', 'female', 'husky', 'small', "reproductive", 'dog', 'https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Chewy', 'dog', '94028', 'adult', 'male', 'corgi', 'small', "reproductive", 'dog', 'https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Charles', 'iguana', '94328', 'adult', 'male', 'fire dragon', 'small', "reproductive", 'iguana', 'https://static.inaturalist.org/photos/95742200/large.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Winston', 'dog', '94020', 'senior', 'male', 'mutt', 'small', "reproductive", 'dog', 'https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg', 0, false, true, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Fuzz Aldrin', 'cat', '88569', 'young', 'male', 'siamese', 'small', "reproductive", 'cat', 'https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Colby', 'cat', '99874', 'young', 'male', 'persian', 'small', "reproductive", 'cat', 'https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Mirabella', 'cat', '88745', 'young', 'female', 'burmese', 'small', "reproductive", 'cat', 'https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Bubbles', 'cat', '33697', 'adult', 'male', 'short hair', 'small', "reproductive", 'cat', 'https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Cheddar', 'cat', '33654', 'adult', 'female', 'american short hair', 'small', "reproductive", 'cat', 'https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Leo', 'cat', '55874', 'adult', 'male', 'birman', 'small', "reproductive", 'cat', 'https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Cora', 'cat', '22698', 'senior', 'female', 'nebelung', 'small', "reproductive", 'cat', 'https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Ajax', 'cat', '33698', 'adult', 'male', 'british long hair', 'small', "reproductive", 'cat', 'https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Andromeda', 'cat', '98745', 'senior', 'female', 'american long hair', 'small', "reproductive", 'cat', 'https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);


INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Perseus', 'dog', '91267', 'adult', 'male', 'german shepherd', 'small', "reproductive", 'dog', 'https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Thor', 'dog', '92428', 'adult', 'male', 'terrier', 'small', "reproductive", 'dog', 'https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Hector', 'dog', '93328', 'young', 'male', 'chihuahua', 'small', "reproductive", 'dog', 'https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Archie', 'dog', '94033', 'young', 'male', 'border collie', 'small', "reproductive", 'dog', 'https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Orion', 'dog', '55488', 'senior', 'male', 'dachshund', 'small', "reproductive", 'dog', 'https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Lulu', 'dog', '66982', 'young', 'female', 'belgian malinois', 'small', "reproductive", 'dog', 'https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Dorothy', 'dog', '86982', 'young', 'female', 'boxer', 'small', "reproductive", 'dog', 'https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Calypso', 'dog', '69982', 'young', 'female', 'labrador', 'small', "reproductive", 'dog', 'https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Cassandra', 'dog', '79982', 'senior', 'female', 'greyhound', 'small', "reproductive", 'dog', 'https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);

INSERT INTO pets(pet_id, owner, name, type, zip, age, sex, breed, weight, reproductive_status, description, cover_photo, favorite_count, reported, adopted, score, city, state, species, date_posted)
VALUES (DEFAULT, 'Owner', 'Maia', 'dog', '89982', 'adult', 'female', 'tibetan spaniel', 'small', "reproductive", 'dog', 'https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg', 0, false, false, 0, 'some city', 'some state', 'some species', DEFAULT);
