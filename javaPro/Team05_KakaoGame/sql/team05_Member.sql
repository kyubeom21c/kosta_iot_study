CREATE TABLE MEMBER 
(
  NUM NUMBER NOT NULL 
, NAME VARCHAR2(20 BYTE) NOT NULL 
, CONSTRAINT MEMBER_PK PRIMARY KEY 
  (
    NUM 
  )
  enable
);

drop table member;

create sequence seq_member_num;

drop sequence seq_member_num;