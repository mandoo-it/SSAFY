use scott;
create table book
(isbn char(8) primary key,
title varchar(50) not null,
author varchar(10) not null,
publisher varchar(15) not null,
price int not null,
description varchar(200));
insert into book values("123-1-14", "Java와 coffee", "diana", "자바닷컴", 8000, "삶의 즐거움");
insert into book values("555-23-2", "AI와 미래", "김현주", "미래닷컴", 20000, null);
insert into book values("123-2-15", "Java와 놀기", "김태희", "자바닷컴", 22000, "Java 정복");
insert into book values("123-6-24", "Java와 알고리즘", "서민규", "자바닷컴", 20000, "성능 업!!");
insert into book values("423-5-23", "IoT세상", "이세준", "미래닷컴", 25000, null);