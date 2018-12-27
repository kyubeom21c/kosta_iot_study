CREATE TABLE SCORE 
(
  NUM NUMBER NOT NULL 
, NAME VARCHAR2(20 BYTE) NOT NULL 
, SCORE NUMBER NOT NULL 
, CONSTRAINT SCORE_PK PRIMARY KEY 
  (
    NUM 
  )
  enable
);

drop table score;

create sequence seq_score_num;

drop sequence seq_score_num;