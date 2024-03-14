CREATE DATABASE study_demo;
USE study_demo;
CREATE TABLE user (
      id BIGINT AUTO_INCREMENT PRIMARY KEY,
      username VARCHAR(255) NOT NULL UNIQUE,
      password VARCHAR(255) NOT NULL
);

