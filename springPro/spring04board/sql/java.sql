create table board(
num number primary key,
title varchar2(100) not null,
content varchar2(1000),
writer varchar2(50) not null,
wdate date default sysdate
);

drop table board;

create sequence seq_board_num;
drop sequence seq_board_num;

insert into board(num,title,content,writer)
values(seq_board_num.nextval,'title33','content33','kim33');

select * from board;
commit;


select * from board order by num desc;

update board set imgname='Chrysanthemum.jpg';






