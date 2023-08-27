INSERT INTO TEAM (id ,name) VALUES (1, 'devTeam');
INSERT INTO TEAM (id ,name) VALUES (2, 'adminTeam');

INSERT INTO ROLES (id ,name) VALUES (1, 'DEV');
INSERT INTO ROLES (id ,name) VALUES (2, 'ADMIN');

INSERT INTO ROLES (id ,name) VALUES (3, 'USER');


INSERT INTO TOPICS (id ,description, name) VALUES (1, 'Frontend Course', 'React Course');

INSERT INTO TEAM_ROLE (team_id, role_id) VALUES (1,1);
INSERT INTO TEAM_ROLE (team_id, role_id) VALUES (2,2);

INSERT INTO USERS VALUES (1,'1234','dareenDev');
INSERT INTO USERS VALUES (2,'1234','dareenAdmin');

INSERT INTO USER_TEAM (user_id, team_id) VALUES (1,1);
INSERT INTO USER_TEAM (user_id, team_id) VALUES (2,2);





