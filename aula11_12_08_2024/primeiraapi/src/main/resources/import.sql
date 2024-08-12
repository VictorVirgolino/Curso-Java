-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;
CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;
INSERT INTO Fruta (Id, nome, qtd) VALUES (nextval('hibernate_sequence'), 'Uva', 5);
INSERT INTO Fruta (Id, nome, qtd) VALUES (nextval('hibernate_sequence'), 'Pera', 4);
INSERT INTO Fruta (Id, nome, qtd) VALUES (nextval('hibernate_sequence'), 'Banana', 3);
INSERT INTO Fruta (Id, nome, qtd) VALUES (nextval('hibernate_sequence'), 'Jaca', 2);
