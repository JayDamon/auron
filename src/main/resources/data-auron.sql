INSERT INTO application (id, application_name) VALUES(1, 'GAUGE');
INSERT INTO application (id, application_name) VALUES(2, 'DEXTER');
INSERT INTO application (id, application_name) VALUES(3, 'ATLAS');
INSERT INTO application (id, application_name) VALUES(4, 'BEACON');
INSERT INTO application (id, application_name) VALUES(5, 'IRIS');
INSERT INTO application (id, application_name) VALUES(6, 'QUALITY');

INSERT INTO feature_type (id, feature_type_name) VALUES (1, 'Primary Feature');
INSERT INTO feature_type (id, feature_type_name) VALUES (2, 'Peril');

INSERT INTO feature (id, feature_name, feature_type_id, application_id) VALUES(1, 'Underwriting', 1, 1);
INSERT INTO feature (id, feature_name, feature_type_id, application_id) VALUES(2, 'Management', 1, 1);
INSERT INTO feature (id, feature_name, feature_type_id, application_id) VALUES(3, 'Risk Maps', 1, 1);
INSERT INTO feature (id, feature_name, feature_type_id, application_id) VALUES(4, 'Damage', 1, 1);
INSERT INTO feature (id, feature_name, feature_type_id, application_id) VALUES(5, 'Tracker', 1, 2);
INSERT INTO feature (id, feature_name, feature_type_id, application_id) VALUES(6, 'Reports', 1, 2);
INSERT INTO feature (id, feature_name, feature_type_id, application_id) VALUES(7, 'Batch Reports', 1, 2);
INSERT INTO feature (id, feature_name, feature_type_id, application_id) VALUES(8, 'Hurricane', 1, 2);
INSERT INTO feature (id, feature_name, feature_type_id, application_id) VALUES(9, 'Hail', 2, 1);
INSERT INTO feature (id, feature_name, feature_type_id, application_id) VALUES(10, 'Tornado', 2, 1);
INSERT INTO feature (id, feature_name, feature_type_id, application_id) VALUES(11, 'Hurricane Surge', 2, 1);
INSERT INTO feature (id, feature_name, feature_type_id, application_id) VALUES(12, 'Wind', 2, 1);
INSERT INTO feature (id, feature_name, feature_type_id, application_id) VALUES(13, 'Flood', 2, 1);

INSERT INTO company (id, company_name) VALUES (1, 'Athenium');
INSERT INTO company (id, company_name) VALUES (2, 'Weather Analytics');
INSERT INTO company (id, company_name) VALUES (3, 'Athenium Analytics');

INSERT INTO app_user (id, created_at, updated_at, first_name, middle_name, last_name, username, email, password, company_id) VALUES (1 ,NOW(), NOW(), 'ADMIN', 'MiddleName', 'ROLE', 'AdminRole', 'email@email.com', '$2a$10$jNEV.uWR/HjHJ.QvY.KNpOR8d.nNMkTQJ4wkWKijcFEHoWBk3zVKG', 1);
INSERT INTO app_user (id, created_at, updated_at, first_name, middle_name, last_name, username, email, password, company_id) VALUES (2, NOW(), NOW(), 'USER', 'MiddleName', 'ROLE', 'UserRole', 'emailTwo@email.com', '$2a$10$2IRPr1rfBvzdO.2bTuSPU.73wEU14yMUzl3lCr3TocI4rpBiaSg/i', 2);

INSERT INTO company_feature(company_id, feature_id) VALUES (1, 1);
INSERT INTO company_feature(company_id, feature_id) VALUES (1, 3);
INSERT INTO company_feature(company_id, feature_id) VALUES (1, 6);
INSERT INTO company_feature(company_id, feature_id) VALUES (1, 7);
INSERT INTO company_feature(company_id, feature_id) VALUES (1, 8);
INSERT INTO company_feature(company_id, feature_id) VALUES (1, 9);
INSERT INTO company_feature(company_id, feature_id) VALUES (2, 1);
INSERT INTO company_feature(company_id, feature_id) VALUES (2, 2);
INSERT INTO company_feature(company_id, feature_id) VALUES (2, 3);
INSERT INTO company_feature(company_id, feature_id) VALUES (2, 4);
INSERT INTO company_feature(company_id, feature_id) VALUES (3, 9);
INSERT INTO company_feature(company_id, feature_id) VALUES (3, 10);
INSERT INTO company_feature(company_id, feature_id) VALUES (3, 11);
INSERT INTO company_feature(company_id, feature_id) VALUES (3, 12);
INSERT INTO company_feature(company_id, feature_id) VALUES (3, 13);

INSERT INTO user_feature(user_id, feature_id) VALUES (1, 1);
INSERT INTO user_feature(user_id, feature_id) VALUES (1, 3);
INSERT INTO user_feature(user_id, feature_id) VALUES (1, 6);
INSERT INTO user_feature(user_id, feature_id) VALUES (1, 7);
INSERT INTO user_feature(user_id, feature_id) VALUES (1, 8);
INSERT INTO user_feature(user_id, feature_id) VALUES (1, 9);
INSERT INTO user_feature(user_id, feature_id) VALUES (2, 1);
INSERT INTO user_feature(user_id, feature_id) VALUES (2, 2);
INSERT INTO user_feature(user_id, feature_id) VALUES (2, 3);
INSERT INTO user_feature(user_id, feature_id) VALUES (2, 4);

