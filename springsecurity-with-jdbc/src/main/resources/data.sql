INSERT INTO users (username, password,enabled)
values ('user1','user1',true);

INSERT INTO users (username, password,enabled)
values ('admin','admin',true);

INSERT INTO authorities (username, authority)
values ('user1','ROLE_USER');

INSERT INTO authorities (username, authority)
values ('admin','ROLE_ADMIN');