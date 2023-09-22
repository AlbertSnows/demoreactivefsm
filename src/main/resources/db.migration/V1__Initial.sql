-- db/migration/V1__Initial.sql
-- Description: Initial database schema
-- Create a sample table
CREATE TABLE users (
    user_id serial PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP NOT NULL);

--DROP TABLE IF EXISTS students;
--CREATE TABLE students(
--    id SERIAL NOT NULL PRIMARY KEY ,
--    firstname VARCHAR(250),
--    lastname VARCHAR(250),
--    age integer);
