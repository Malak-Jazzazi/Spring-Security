INSERT INTO book (name, author, type)
VALUES ('To Kill a Mockingbird', 'Harper Lee', 'Classic');
INSERT INTO book (name, author, type)
VALUES ('1984', 'George Orwell', 'Dystopian');
INSERT INTO book (name, author, type)
VALUES ('Pride and Prejudice', 'Jane Austen', 'Romance');
INSERT INTO book (name, author, type)
VALUES ('The Great Gatsby', 'F. Scott Fitzgerald', 'Fiction');
INSERT INTO book (name, author, type)
VALUES ('The Catcher in the Rye', 'J.D. Salinger', 'Coming-of-age');
INSERT INTO book (name, author, type)
VALUES ('To the Lighthouse', 'Virginia Woolf', 'Modernist');
INSERT INTO book (name, author, type)
VALUES ('The Lord of the Rings', 'J.R.R. Tolkien', 'Fantasy');
INSERT INTO book (name, author, type)
VALUES ('The Hunger Games', 'Suzanne Collins', 'Young adult');
INSERT INTO book (name, author, type)
VALUES ('The Da Vinci Code', 'Dan Brown', 'Mystery');
INSERT INTO book (name, author, type)
VALUES ('The Picture of Dorian Gray', 'Oscar Wilde', 'Gothic');


INSERT INTO store (location, notes, phone_number)
VALUES ('Amman', 'Capital city of Jordan', '+962 6 1234567');
INSERT INTO store (location, notes, phone_number)
VALUES ('Irbid', 'City in northern Jordan', '+962 2 1234567');
INSERT INTO store (location, notes, phone_number)
VALUES ('Aqaba', 'City on the Red Sea coast', '+962 3 1234567');
INSERT INTO store (location, notes, phone_number)
VALUES ('Madaba', 'City known for its Byzantine mosaics', '+962 5 1234567');
INSERT INTO store (location, notes, phone_number)
VALUES ('Jerash', 'City with well-preserved Roman ruins', '+962 2 1234567');
INSERT INTO store (location, notes, phone_number)
VALUES ('Zarqa', 'Industrial city located east of Amman', '+962 5 1234567');

INSERT INTO role (name, description)
VALUES ('ROLE_storeAdmin', 'Role with access to all endpoints');
INSERT INTO role (name, description)
VALUES ('ROLE_normalUser', 'Role with limited access to certain endpoints');
INSERT INTO role (name, description)
VALUES ('ROLE_default', 'Role assigned to all new users by default');

INSERT INTO user_user (username, password, firstname, lastname, phone_number)
VALUES ('user1', 'password1', 'Ahmed', 'Al-Masri', '+962799876543');
INSERT INTO user_user (username, password, firstname, lastname, phone_number)
VALUES ('user2', 'password2', 'Hassan', 'Al-Zoubi', '+962777654321');
INSERT INTO user_user (username, password, firstname, lastname, phone_number)
VALUES ('user3', 'password3','Asma', 'Haddad', '+962788765432');
INSERT INTO user_user (username, password, firstname, lastname, phone_number)
VALUES ('user4', 'password4','Omar', 'Al-Khaldi', '+962799987654');
INSERT INTO user_user (username, password, firstname, lastname, phone_number)
VALUES ('user5', 'password5', 'Fatima', 'Al-Maqdisi', '+962799112233');
INSERT INTO user_user (username, password, firstname, lastname, phone_number)
VALUES ('user6', 'password6', 'Sami', 'Al-Safadi', '+962788876543');
INSERT INTO user_user (username, password, firstname, lastname, phone_number)
VALUES ('user7', 'password7', 'Nada', 'Al-Qudsi', '+962799998877');
INSERT INTO user_user (username, password, firstname, lastname, phone_number)
VALUES ('user8', 'password8', 'Tariq', 'Al-Faris', '+962777887766');
INSERT INTO user_user (username, password, firstname, lastname, phone_number)
VALUES ('user9', 'password9', 'Dana', 'Al-Jarrah', '+962788556677');
INSERT INTO user_user (username, password, firstname, lastname, phone_number)
VALUES ('user10', 'password10', 'Khaled', 'Al-Hussein', '+962799334455');

INSERT INTO store_book (store_id, book_id)
SELECT s.id, b.id
FROM store s
         CROSS JOIN book b
WHERE s.id <= 6
  AND b.id <= 10
  AND RAND() < 0.5
GROUP BY s.id, b.id
HAVING COUNT(*) < 5;

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 1);

INSERT INTO user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO user_role (user_id, role_id) VALUES (4, 2);
INSERT INTO user_role (user_id, role_id) VALUES (5, 2);

INSERT INTO user_role (user_id, role_id) VALUES (6, 3);
INSERT INTO user_role (user_id, role_id) VALUES (7, 3);
INSERT INTO user_role (user_id, role_id) VALUES (8, 3);
INSERT INTO user_role (user_id, role_id) VALUES (9, 3);
INSERT INTO user_role (user_id, role_id) VALUES (10, 3);
