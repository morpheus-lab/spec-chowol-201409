CREATE TABLE board (
  bno       NUMBER(10)      PRIMARY KEY,
  subject   VARCHAR2(100)   NOT NULL,
  content   VARCHAR2(4000)  NOT NULL,
  writer    VARCHAR2(100)   NOT NULL,
  writedate DATE            NOT NULL,
  hitcount  NUMBER(10)      NOT NULL
);

CREATE SEQUENCE seq_board_bno;

CREATE TABLE boardfile (
  fno           NUMBER(10)      PRIMARY KEY,
  bno           NUMBER(10)      NOT NULL,
  originalname  VARCHAR2(100)   NOT NULL,
  savedname     VARCHAR2(100)   NOT NULL,
  contenttype   VARCHAR2(100)   NOT NULL
);

CREATE SEQUENCE seq_boardfile_fno;