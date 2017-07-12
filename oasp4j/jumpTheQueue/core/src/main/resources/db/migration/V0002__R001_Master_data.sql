INSERT INTO Visitor (id, modificationCounter, name, email, phone, idCode) VALUES (1, 1, 'Jason', 'jason@mail.com', '123456', 1);
INSERT INTO Visitor (id, modificationCounter, name, email, phone, idCode) VALUES (2, 1, 'Peter', 'peter@mail.com', '789101', 2);


INSERT INTO AccessCode (id, modificationCounter, code, dateAndTime, idVisitor) VALUES (1, 1, 'A01', CURRENT_TIMESTAMP + (60 * 60 * 24 * 5), 1);
INSERT INTO AccessCode (id, modificationCounter, code, dateAndTime, idVisitor) VALUES (2, 1, 'A02', CURRENT_TIMESTAMP + (60 * 60 * 24 * 5), 2);