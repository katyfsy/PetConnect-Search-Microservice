-- SET check_function_bodies = false;

-- /* Reset */
-- DROP DATABASE test IF EXISTS;
-- CREATE test;


-- ==== THIS IS JUST AN EXAMPLE / CHANGE SCHEMA TO REFLECT CURRENT PROJECT ===
/* Table 'questions' */
CREATE TABLE questions(
  id serial NOT NULL,
  product_id integer NOT NULL,
  body text NOT NULL,
  date_written bigint NOT NULL,
  asker_name varchar(255),
  asker_email text,
  reported bool,
  helpful integer,
  PRIMARY KEY(id)
);

/* Table 'answers' */
CREATE TABLE answers(
  id serial NOT NULL,
  body text,
  date_written bigint NOT NULL,
  answerer_name varchar(255),
  answerer_email text,
  reported bool,
  helpful integer,
  questions_id integer NOT NULL,
  PRIMARY KEY(id)
);

/* Table 'answer_photos' */
CREATE TABLE answer_photos(
  id serial NOT NULL,
  url text,
  answers_id integer NOT NULL,
  questions_id integer NOT NULL,
  PRIMARY KEY(id)
);

/* Relation 'questions_answers' */
ALTER TABLE answers
  ADD CONSTRAINT questions_answers
    FOREIGN KEY (questions_id) REFERENCES questions (id);

/* Relation 'answers_answer_photos' */
ALTER TABLE answer_photos
  ADD CONSTRAINT answers_answer_photos
    FOREIGN KEY (answers_id) REFERENCES answers (id);

/* Relation 'questions_answer_photos' */
ALTER TABLE answer_photos
  ADD CONSTRAINT questions_answer_photos
    FOREIGN KEY (questions_id) REFERENCES questions (id);
