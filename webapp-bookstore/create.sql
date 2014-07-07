CREATE DATABASE book_db;
USE book_db;

CREATE TABLE user_account(
	email    VARCHAR(30) PRIMARY KEY,
	name	 VARCHAR(15) NOT NULL, 
	password VARCHAR(10) NOT NULL
);

CREATE TABLE publisher (
	code CHAR(3) PRIMARY KEY,
	name VARCHAR(20) NOT NULL
);

CREATE TABLE book (
	isbn           CHAR(17) PRIMARY KEY,
	title          VARCHAR(70) NOT NULL,
	publisher_code CHAR(3) NOT NULL,
	price          DOUBLE NOT NULL,
	release_date   DATE,
	FOREIGN KEY(publisher_code) REFERENCES publisher(code)
);

CREATE TABLE author (
	code CHAR(3) PRIMARY KEY,
	name VARCHAR(20) NOT NULL
);

CREATE TABLE book_author (
	isbn        CHAR(17) NOT NULL,
	author_code CHAR(3)  NOT NULL,
	PRIMARY KEY(isbn, author_code),
	FOREIGN KEY(isbn) REFERENCES book(isbn),
	FOREIGN KEY(author_code) REFERENCES author(code)
);

INSERT INTO user_account VALUES('admin@example.com', 'Admin', 'admin');

INSERT INTO publisher VALUES('001', 'O\'Reilly');
INSERT INTO publisher VALUES('002', 'Wiley / Wrox');
INSERT INTO publisher VALUES('003', 'PACKT Publishing');
INSERT INTO publisher VALUES('004', 'Apress');
INSERT INTO publisher VALUES('005', 'MANNING PUBLICATIONS');

INSERT INTO author VALUES('001', 'Patrick Mulder');
INSERT INTO author VALUES('002', 'Brian Knight');
INSERT INTO author VALUES('003', 'Devin Knight');
INSERT INTO author VALUES('004', 'Jessica M. Moss');
INSERT INTO author VALUES('005', 'Mike Davis');
INSERT INTO author VALUES('006', 'Chris Rock');
INSERT INTO author VALUES('007', 'Debu Panda');
INSERT INTO author VALUES('008', 'Reza Rahman');
INSERT INTO author VALUES('009', 'Ryan Cuprak');
INSERT INTO author VALUES('010', 'Michael Remijan');
INSERT INTO author VALUES('011', 'Joachim Haagen Skeie');
INSERT INTO author VALUES('012', 'Vijay Joshi');
INSERT INTO author VALUES('013', 'Sandeep Karanth');
INSERT INTO author VALUES('014', 'Ian F. Darwin');
INSERT INTO author VALUES('015', 'Neal Ford');
INSERT INTO author VALUES('016', 'Jeff Mesnil');
INSERT INTO author VALUES('017', 'Julia Elman');
INSERT INTO author VALUES('018', 'Mark Lavin');
INSERT INTO author VALUES('019', 'Jeroen Janssens');
INSERT INTO author VALUES('020', 'Jon Galloway');
INSERT INTO author VALUES('021', 'Phil Haack');
INSERT INTO author VALUES('022', 'Brad Wilson');
INSERT INTO author VALUES('023', 'K. Scott Allen');
INSERT INTO author VALUES('024', 'Scott Hanselman');
INSERT INTO author VALUES('025', 'Andrew Curioso');
INSERT INTO author VALUES('026', 'Ronald Bradford');
INSERT INTO author VALUES('027', 'Patrick Galbraith');
INSERT INTO author VALUES('028', 'Carl Dea');
INSERT INTO author VALUES('029', 'Mark Heckler');
INSERT INTO author VALUES('030', 'Gerrit Grunwald');
INSERT INTO author VALUES('031', 'José Pereda');
INSERT INTO author VALUES('032', 'Sean Phillips');
INSERT INTO author VALUES('033', 'Jeff Linwood');
INSERT INTO author VALUES('034', 'Dave Minter');

INSERT INTO book VALUES('978-1-4493-7093-0', 'Full Stack Web Development with Backbone.js', '001', 23.99, '2014-06-01');
INSERT INTO book VALUES('978-1-4920-0592-6', 'Professional Microsoft SQL Server 2014 Integration Services', '002', 54.99, '2014-04-01');
INSERT INTO book VALUES('978-1-7839-8364-3', 'Mastering Hadoop: RAW', '003', 27.99, '2014-07-01');
INSERT INTO book VALUES('978-1-4919-0939-3', 'Lightweight Django', '001', 33.99, '2014-06-15');
INSERT INTO book VALUES('978-1-4302-6460-6', 'JavaFX 8: Introduction by Example', '004', 27.99, '2014-06-3');
INSERT INTO book VALUES('978-1-6172-9145-6', 'Ember.js in Action', '005', 35.99, '2014-05-30');
INSERT INTO book VALUES('978-1-4919-0658-3', 'Functional Thinking', '001', 32.99, '2014-05-01');
INSERT INTO book VALUES('978-1-1184-2432-2', 'Professional ASP.NET MVC 4', '002', 42.99, '2013-09-11');
INSERT INTO book VALUES('978-1-7832-8665-2', 'Mastering jQuery UI', '003', 37.99, '2014-07-01');
INSERT INTO book VALUES('978-1-4919-4778-4', 'Data Science at the Command Line', '001', 33.99, '2014-06-23');
INSERT INTO book VALUES('978-1-4919-0836-5', 'Mobile and Web Messaging', '001', 19.99, '2014-06-23');
INSERT INTO book VALUES('978-1-4302-6517-7', 'Beginning Hibernate', '004', 34.99, '2014-04-06');
INSERT INTO book VALUES('978-0-470-56312-0', 'Expert PHP and MySQL', '002', 38.99, '2013-12-15');
INSERT INTO book VALUES('978-1-9351-8299-3', 'EJB 3 in Action, Second Edition', '005', 43.99, '2014-03-12');
INSERT INTO book VALUES('978-1-4493-3703-2', 'Java Cookbook, 3rd Edition', '001', 32.99, '2014-06-07');

INSERT INTO book_author VALUES('978-1-4493-7093-0', '001');
INSERT INTO book_author VALUES('978-1-4920-0592-6', '002');
INSERT INTO book_author VALUES('978-1-4920-0592-6', '003');
INSERT INTO book_author VALUES('978-1-4920-0592-6', '004');
INSERT INTO book_author VALUES('978-1-4920-0592-6', '005');
INSERT INTO book_author VALUES('978-1-4920-0592-6', '006');
INSERT INTO book_author VALUES('978-1-9351-8299-3', '007');
INSERT INTO book_author VALUES('978-1-9351-8299-3', '008');
INSERT INTO book_author VALUES('978-1-9351-8299-3', '009');
INSERT INTO book_author VALUES('978-1-9351-8299-3', '010');
INSERT INTO book_author VALUES('978-1-6172-9145-6', '011');
INSERT INTO book_author VALUES('978-1-7832-8665-2', '012');
INSERT INTO book_author VALUES('978-1-7839-8364-3', '013');
INSERT INTO book_author VALUES('978-1-4493-3703-2', '014');
INSERT INTO book_author VALUES('978-1-4919-0658-3', '015');
INSERT INTO book_author VALUES('978-1-4919-0836-5', '016');
INSERT INTO book_author VALUES('978-1-4919-0939-3', '017');
INSERT INTO book_author VALUES('978-1-4919-0939-3', '018');
INSERT INTO book_author VALUES('978-1-4919-4778-4', '019');
INSERT INTO book_author VALUES('978-1-1184-2432-2', '020');
INSERT INTO book_author VALUES('978-1-1184-2432-2', '021');
INSERT INTO book_author VALUES('978-1-1184-2432-2', '022');
INSERT INTO book_author VALUES('978-1-1184-2432-2', '023');
INSERT INTO book_author VALUES('978-1-1184-2432-2', '024');
INSERT INTO book_author VALUES('978-0-470-56312-0', '025');
INSERT INTO book_author VALUES('978-0-470-56312-0', '026');
INSERT INTO book_author VALUES('978-0-470-56312-0', '027');
INSERT INTO book_author VALUES('978-1-4302-6460-6', '028');
INSERT INTO book_author VALUES('978-1-4302-6460-6', '029');
INSERT INTO book_author VALUES('978-1-4302-6460-6', '030');
INSERT INTO book_author VALUES('978-1-4302-6460-6', '031');
INSERT INTO book_author VALUES('978-1-4302-6460-6', '032');
INSERT INTO book_author VALUES('978-1-4302-6517-7', '033');
INSERT INTO book_author VALUES('978-1-4302-6517-7', '034');

