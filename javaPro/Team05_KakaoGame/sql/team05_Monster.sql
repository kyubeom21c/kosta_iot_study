CREATE TABLE MONSTER 
(
  NUM NUMBER NOT NULL 
, NAME VARCHAR2(20 BYTE) NOT NULL 
, HP NUMBER NOT NULL 
, ATTACK NUMBER NOT NULL 
, DEFENSE NUMBER NOT NULL 
, CONSTRAINT MONSTER_PK PRIMARY KEY 
  (
    NUM 
  )
  enable
);

drop table monster;

create sequence seq_monster_num;

drop sequence seq_monster_num;