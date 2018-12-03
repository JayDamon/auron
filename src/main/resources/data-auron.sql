INSERT INTO app_role (role_name) VALUES ('ROLE_USER');
INSERT INTO app_role (role_name) VALUES ('ROLE_ADMIN');

INSERT INTO app_user (id, created_at, updated_at, first_name, middle_name, last_name, username, email, password) VALUES (1 ,NOW(), NOW(), 'ADMIN', 'MiddleName', 'ROLE', 'AdminRole', 'email@email.com', '$2a$10$jNEV.uWR/HjHJ.QvY.KNpOR8d.nNMkTQJ4wkWKijcFEHoWBk3zVKG');
INSERT INTO app_user (id, created_at, updated_at, first_name, middle_name, last_name, username, email, password) VALUES (2, NOW(), NOW(), 'USER', 'MiddleName', 'ROLE', 'UserRole', 'emailTwo@email.com', '$2a$10$2IRPr1rfBvzdO.2bTuSPU.73wEU14yMUzl3lCr3TocI4rpBiaSg/i');

INSERT INTO user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO user_role (user_id, role_id) VALUES (2, 1);