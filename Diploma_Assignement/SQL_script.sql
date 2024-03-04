CREATE DATABASE IF NOT EXISTS SQL_script;
USE SQL_script;

DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
    `password` VARCHAR(50) NOT NULL,
    `username` VARCHAR(50) UNIQUE NOT NULL,
    `role` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`username`)
);

DROP TABLE IF EXISTS `Student`;
CREATE TABLE `Student`(
	`username` VARCHAR(50) NOT NULL,
    `full_name` VARCHAR(50),
    `year_of_studies` INTEGER NOT NULL,
    `current_average_grade` FLOAT NOT NULL,
    `number_of_remaining_courses_for_graduation` INTEGER NOT NULL,
    `studentId` INTEGER UNIQUE NOT NULL AUTO_INCREMENT,
    PRIMARY KEY(`studentId`),
    FOREIGN KEY(`username`) REFERENCES `User`(`username`)
)AUTO_INCREMENT = 1;

DROP TABLE IF EXISTS `Professor`;
CREATE TABLE `Professor`(
	`username` VARCHAR(50) NOT NULL,
    `full_name` VARCHAR(50),
    `specialty` VARCHAR(20),
    `professorId` INTEGER UNIQUE NOT NULL AUTO_INCREMENT,
    `threshold1` FLOAT NOT NULL,
    `threshold2` INTEGER NOT NULL,
    PRIMARY KEY(`professorId`),
    FOREIGN KEY(`username`) REFERENCES `User`(`username`)
)AUTO_INCREMENT = 1;

DROP TABLE IF EXISTS `Subject`;
CREATE TABLE `Subject`(
    `title` VARCHAR(20),
    `objectives` VARCHAR(50),
    `supervisor` VARCHAR(50),
    `subjectId` INTEGER UNIQUE NOT NULL AUTO_INCREMENT,
    PRIMARY KEY(`subjectId`)
)AUTO_INCREMENT = 1;

DROP TABLE IF EXISTS `Thesis`;
CREATE TABLE `Thesis`(
	`subjectId` INTEGER NOT NULL,
    `studentId` INTEGER NOT NULL,
    `title` VARCHAR(20),
    `objectives` VARCHAR(50),
    `supervisor` VARCHAR(50),
    `subject` VARCHAR(20),
    `student` VARCHAR(20),
    `thesisId` INTEGER UNIQUE NOT NULL AUTO_INCREMENT,
    PRIMARY KEY(`thesisId`),
    FOREIGN KEY(`subjectId`) REFERENCES `Subject`(`subjectId`),
    FOREIGN KEY(`studentId`) REFERENCES `Student`(`studentId`)
)AUTO_INCREMENT = 1;

DROP TABLE IF EXISTS `Application`;
CREATE TABLE `Application`(
	`subjectId` INTEGER NOT NULL,
    `studentId` INTEGER NOT NULL,
    `applicationId` INTEGER UNIQUE NOT NULL AUTO_INCREMENT,
    `student` VARCHAR(20), 
    `subject` VARCHAR(20),
    `professor` VARCHAR(20),
    PRIMARY KEY(`applicationId`),
    FOREIGN KEY(`subjectId`) REFERENCES `Subject`(`subjectId`),
    FOREIGN KEY(`studentId`) REFERENCES `Student`(`studentId`)
)AUTO_INCREMENT = 1;