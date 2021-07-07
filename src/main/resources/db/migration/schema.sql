DROP TABLE IF EXISTS HERO;

CREATE TABLE HERO (
id INT AUTO_INCREMENT  PRIMARY KEY,
hero_name VARCHAR(50) NOT NULL,
hidden_name VARCHAR(50),
hidden_last_name VARCHAR(50)
);

DROP TABLE IF EXISTS SKILL;

CREATE TABLE SKILL (
id INT AUTO_INCREMENT  PRIMARY KEY,
name VARCHAR(50) NOT NULL,
description VARCHAR(200),
heroId INT NOT NULL
);

ALTER TABLE SKILL
    ADD FOREIGN KEY (heroId)
    REFERENCES HERO(id);
