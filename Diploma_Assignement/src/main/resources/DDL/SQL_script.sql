--CREATE DATABASE IF NOT EXISTS SQL_script;

--USE sql_script;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
    user_id INTEGER  AUTO_INCREMENT,
    username VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL,
    PRIMARY KEY (user_id)
);

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`(
	username VARCHAR(100) UNIQUE NOT NULL,
    full_name VARCHAR(100) DEFAULT NULL,
    year_of_studies INTEGER DEFAULT NULL,
    current_average_grade FLOAT DEFAULT NULL,
    number_of_remaining_courses_for_graduation INTEGER DEFAULT NULL,
    student_id INTEGER UNIQUE NOT NULL AUTO_INCREMENT,
    PRIMARY KEY(student_id),
    FOREIGN KEY(username) REFERENCES `user`(username)
);

DROP TABLE IF EXISTS `professor`;
CREATE TABLE `professor`(
	username VARCHAR(100) UNIQUE NOT NULL,
    full_name VARCHAR(100) DEFAULT NULL,
    specialty VARCHAR(50) DEFAULT NULL,
    professor_id INTEGER UNIQUE NOT NULL AUTO_INCREMENT,
    threshold1 FLOAT DEFAULT NULL,
    threshold2 INTEGER DEFAULT NULL,
    PRIMARY KEY(professor_id),
    FOREIGN KEY(username) REFERENCES `user`(username)
);

DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject`(
    title VARCHAR(50),
    objectives VARCHAR(100),
    professor_id INTEGER,
    subject_id INTEGER UNIQUE NOT NULL AUTO_INCREMENT,
    PRIMARY KEY(subject_id),
    FOREIGN KEY(professor_id) REFERENCES `professor`(professor_id)
);

DROP TABLE IF EXISTS `thesis`;
CREATE TABLE `thesis`(
	subject_id INTEGER,
    student_id INTEGER,
    title VARCHAR(50),
    objectives VARCHAR(100),
    professor_id INTEGER,
    thesis_id INTEGER UNIQUE NOT NULL AUTO_INCREMENT,
    grade FLOAT,
    PRIMARY KEY(thesis_id),
    FOREIGN KEY(subject_id) REFERENCES `subject`(subject_id),
    FOREIGN KEY(student_id) REFERENCES `student`(student_id),
    FOREIGN KEY(professor_id) REFERENCES `professor`(professor_id)
);

DROP TABLE IF EXISTS `application`;
CREATE TABLE `application`(
	subject_id INTEGER,
    application_id INTEGER UNIQUE NOT NULL AUTO_INCREMENT,
    student_id INTEGER,
    professor_id INTEGER,
    PRIMARY KEY(application_id),
    FOREIGN KEY(subject_id) REFERENCES `subject`(subject_id),
    FOREIGN KEY(student_id) REFERENCES `student`(student_id),
    FOREIGN KEY(professor_id) REFERENCES `professor`(professor_id)
);
