CREATE DATABASE IF NOT EXISTS genealogy
    DEFAULT CHARACTER SET utf8
    COLLATE utf8_hungarian_ci;

USE genealogy;

CREATE TABLE IF NOT EXISTS people
(
    id              BINARY(16) DEFAULT (UUID_TO_BIN(UUID())) NOT NULL PRIMARY KEY,
    first_name      VARCHAR(255)                             NOT NULL,
    middle_name     VARCHAR(255),
    last_name       VARCHAR(255)                             NOT NULL,
    place_of_birth  VARCHAR(25),
    date_of_birth   DATE,
    place_of_death  VARCHAR(25),
    date_of_death   DATE,
    photo_file_name VARCHAR(41)
);

CREATE TABLE person_parents
(
    person_id BINARY(16) NOT NULL,
    parent_id BINARY(16) NOT NULL,
    PRIMARY KEY (person_id, parent_id),
    CONSTRAINT fk_person_parents___person_id__person_id
        FOREIGN KEY (person_id) REFERENCES people (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    CONSTRAINT fk_person_parents___parent_id__person_id
        FOREIGN KEY (parent_id) REFERENCES people (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);

CREATE TABLE person_children
(
    person_id BINARY(16) NOT NULL,
    child_id  BINARY(16) NOT NULL,
    PRIMARY KEY (person_id, child_id),
    CONSTRAINT fk_person_children___person_id_person_id
        FOREIGN KEY (person_id) REFERENCES people (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    CONSTRAINT fk_person_children___child_id__person_id
        FOREIGN KEY (child_id) REFERENCES people (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS person_siblings
(
    person_id  BINARY(16) NOT NULL,
    sibling_id BINARY(16) NOT NULL,
    PRIMARY KEY (person_id, sibling_id),
    CONSTRAINT fk_person_siblings___person_id__person_id
        FOREIGN KEY (person_id) REFERENCES people (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    CONSTRAINT fk_person_siblings___sibling_id__person_id
        FOREIGN KEY (sibling_id) REFERENCES people (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);
