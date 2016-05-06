CREATE TABLE books
(id INTEGER PRIMARY KEY AUTO_INCREMENT,
 author_first_name VARCHAR(30),
 author_last_name VARCHAR(30),
 title VARCHAR(50),
 publisher VARCHAR(30),
 year INTEGER,
 ISBN VARCHAR(50),
 genre VARCHAR(30),
 read BOOLEAN,
 stars INTEGER)
