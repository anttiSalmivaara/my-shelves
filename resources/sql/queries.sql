-- :name add-book! :! :n
-- :doc creates a new user record
INSERT INTO books
(author_first_name, author_last_name, title, publisher, year, ISBN, genre, read, stars)
VALUES (:author_first_name, :author_last_name, :title, :publisher, :year, :ISBN, :genre, :read, :stars)

-- :name update-book! :! :n
-- :doc update an existing user record
UPDATE books
SET author_first_name = :author_first_name, author_last_name = :author_last_name, title = :title, publisher = :publisher, year = :year, ISBN = :ISBN, genre = :genre, read = :read, stars = :stars
WHERE id = :id

-- :name get-all-books! :? :*
-- :doc retrieve all books
SELECT * FROM books

-- :name get-book! :? :1
-- :doc retrieve a book given the id.
SELECT * FROM books
WHERE id = :id

-- :name delete-book! :! :n
-- :doc delete a book given the id
DELETE FROM books
WHERE id = :id
