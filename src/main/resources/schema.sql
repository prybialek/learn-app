CREATE TABLE T_USER (
  id          INTEGER PRIMARY KEY,
  name        VARCHAR2(255) NOT NULL,
  salary      INTEGER NOT NULL
);

CREATE SEQUENCE T_USER_SEQ START WITH 1000 INCREMENT BY 1;
