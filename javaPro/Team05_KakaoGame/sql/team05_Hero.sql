CREATE TABLE HERO 
(
  NUM NUMBER NOT NULL 
, NAME VARCHAR2(20 BYTE) NOT NULL 
, HP NUMBER NOT NULL 
, ATTACK NUMBER NOT NULL 
, DEFENSE NUMBER NOT NULL 
, CONSTRAINT HERO_PK PRIMARY KEY 
  (
    NUM 
  )
  enable
);

drop table hero;

create sequence seq_hero_num;

drop sequence seq_hero_num;