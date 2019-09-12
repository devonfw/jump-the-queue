INSERT INTO Visitor (id, modificationCounter, username, name, password, phoneNumber, acceptedComercial, acceptedTerms, userType) VALUES (0, 1, 'mike@mail.com', 'test', '1', '123456789', '0', '1', '1');
INSERT INTO Visitor (id, modificationCounter, username, name, password, phoneNumber, acceptedComercial, acceptedTerms, userType) VALUES (1, 1, 'peter@mail.com', 'test', '1', '123456789', '1', '1', '0');
INSERT INTO Visitor (id, modificationCounter, username, name, password, phoneNumber, acceptedComercial, acceptedTerms, userType) VALUES (2, 1, 'pablo@mail.com', 'test', '1', '123456789', '0', '1', '0');
INSERT INTO Visitor (id, modificationCounter, username, name, password, phoneNumber, acceptedComercial, acceptedTerms, userType) VALUES (3, 1, 'test1@mail.com', 'test', '1', '123456789', '0', '1', '0');
INSERT INTO Visitor (id, modificationCounter, username, name, password, phoneNumber, acceptedComercial, acceptedTerms, userType) VALUES (4, 1, 'test2@mail.com', 'test', '1', '123456789', '1', '1', '0');
INSERT INTO Visitor (id, modificationCounter, username, name, password, phoneNumber, acceptedComercial, acceptedTerms, userType) VALUES (5, 1, 'test3@mail.com', 'test', '1', '123456789', '0', '1', '0');
INSERT INTO Visitor (id, modificationCounter, username, name, password, phoneNumber, acceptedComercial, acceptedTerms, userType) VALUES (6, 1, 'test4@mail.com', 'test', '1', '123456789', '0', '1', '0');
INSERT INTO Visitor (id, modificationCounter, username, name, password, phoneNumber, acceptedComercial, acceptedTerms, userType) VALUES (7, 1, 'test5@mail.com', 'test', '1', '123456789', '1', '1', '0');
INSERT INTO Visitor (id, modificationCounter, username, name, password, phoneNumber, acceptedComercial, acceptedTerms, userType) VALUES (8, 1, 'test6@mail.com', 'test', '1', '123456789', '0', '1', '0');
INSERT INTO Visitor (id, modificationCounter, username, name, password, phoneNumber, acceptedComercial, acceptedTerms, userType) VALUES (9, 1, 'test7@mail.com', 'test', '1', '123456789', '0', '1', '0');

INSERT INTO DailyQueue (id, modificationCounter, name, logo, currentNumber, attentionTime, minAttentionTime, active, customers) VALUES (1, 1, 'Day2', 'C:/logos/Day1Logo.png', 'Q001', NULL, '1970-01-01 00:01:00', TRUE, 9);

INSERT INTO AccessCode (id, modificationCounter, ticketNumber, creationTime, startTime, endTime, idVisitor, idQueue) VALUES (1, 1, 'Q001', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, 1, 1);
INSERT INTO AccessCode (id, modificationCounter, ticketNumber, creationTime, startTime, endTime, idVisitor, idQueue) VALUES (2, 1, 'Q002', CURRENT_TIMESTAMP, '2008-01-01 00:00:01', NULL, 2, 1);
INSERT INTO AccessCode (id, modificationCounter, ticketNumber, creationTime, startTime, endTime, idVisitor, idQueue) VALUES (3, 1, 'Q003', CURRENT_TIMESTAMP, '2008-01-01 00:00:01', NULL, 3, 1);
INSERT INTO AccessCode (id, modificationCounter, ticketNumber, creationTime, startTime, endTime, idVisitor, idQueue) VALUES (4, 1, 'Q004', CURRENT_TIMESTAMP, '2008-01-01 00:00:01', NULL, 4, 1);
INSERT INTO AccessCode (id, modificationCounter, ticketNumber, creationTime, startTime, endTime, idVisitor, idQueue) VALUES (5, 1, 'Q005', CURRENT_TIMESTAMP, '2008-01-01 00:00:01', NULL, 5, 1);
INSERT INTO AccessCode (id, modificationCounter, ticketNumber, creationTime, startTime, endTime, idVisitor, idQueue) VALUES (6, 1, 'Q006', CURRENT_TIMESTAMP, '2008-01-01 00:00:01', NULL, 6, 1);
INSERT INTO AccessCode (id, modificationCounter, ticketNumber, creationTime, startTime, endTime, idVisitor, idQueue) VALUES (7, 1, 'Q007', CURRENT_TIMESTAMP, '2008-01-01 00:00:01', NULL, 7, 1);
INSERT INTO AccessCode (id, modificationCounter, ticketNumber, creationTime, startTime, endTime, idVisitor, idQueue) VALUES (8, 1, 'Q008', CURRENT_TIMESTAMP, '2008-01-01 00:00:01', NULL, 8, 1);
INSERT INTO AccessCode (id, modificationCounter, ticketNumber, creationTime, startTime, endTime, idVisitor, idQueue) VALUES (9, 1, 'Q009', CURRENT_TIMESTAMP, '2008-01-01 00:00:01', NULL, 9, 1);


