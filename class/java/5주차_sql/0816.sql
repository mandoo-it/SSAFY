desc emp;
insert into emp(empid, fname, lname, email, phone, hdate) values(999,'dd','lee', 'tomtom', '12321321',now());
-- 모든 컬럼에 데이터 입력
select count(*) from emp;

delete from emp where empid = 998;
select * from emp where empid = 998;

update emp set email='abc', lname='qqq' where empid = 999;
rollback;
select * from emp where empid = 999;

use scott;
select empid,fname,salary,
case 
	when salary>15000 then 'high'
    when salary>8000 then 'mid'
    else 'low'
end grade
from emp;

-- ifnull
select fname, comm, if(comm, 1, 0), ifnull(comm, 'none'), coalesce(comm,'nope') from emp;
select deptid, jobid, avg(salary) from emp where deptid > 50 group by deptid having avg(salary) > 7000 order by deptid;
select empid, fname,salary from emp order by salary desc limit 5; -- 상위 5개 코드

create table test(id int(3) primary key, name varchar(10) not null);

create table test2(id int(3) auto_increment primary key, name varchar(10) not null);
desc test2;

insert into test2 values(1,'rom');
desc test2;
select * from test2;
insert into test2 values(null,'bill');
select * from test2;

alter table test add tel varchar(10);
desc test;

alter table test drop tel;
desc test;

drop table test2;

create table emp2 as select * from emp;
drop table emp2;
create table sales as select * from emp where jobid like 'SA%';
select * from sales;

-- 제약조건
-- pk : inline
create table test(id int(3) primary key, name varchar(20) not null);
-- outline
create table test2(id int(3), name varchar(20) not null, constraint test2_pk primary key(id));
-- after creation
create table test3(id int(3), name varchar(20) not null);
alter table test3 add constraint test3_pk primary key(id);
-- drop table emp;
alter table emp add constraint emp_pk primary key(empid);
alter table dept add constraint dept_pk primary key(deptid);
alter table loc add constraint loc_pk primary key(locid);
alter table job add constraint job_pk primary key(jobid);
alter table emp add constraint emp_fk_dept foreign key(deptid) references dept(deptid);
alter table emp add constraint emp_fk_job foreign key(jobid) references job(jobid);
alter table emp add constraint emp_fk_mgr foreign key(mgrid) references emp(empid);
alter table dept add constraint dept_fk_loc foreign key(locid) references loc(locid);
alter table dept add constraint dept_fk_mgr foreign key(mgrid) references emp(empid);

create table test9(id int(3), name varchar(20) unique, age int(3) not null, constraint agecheck check(age > 30));
create table test9(id int(3), name varchar(20) unique, age int(3) not null, constraint codecheck check(code in('a', 'b','c')));
insert into test9 values(1, "ammd", -9);
insert into test9 values(11,'ada','z');
create table test9(id int(3) primary key, name varchar(20) default 'jane', age int(10) not null, constraint agecheck check(age>30));
select * from test9;

-- 멤버
create table member(mid varchar(5) auto_increment primary key, name varchar(10) not null, tel varchar(13) not null, addr varchar(20) not null);
create table orders(oid int(3) primary key, mid varchar(5), odate timestamp default current_timestamp, payment varchar(10) default 'creditcard' not null);
alter table orders add constraint orders_fk foreign key(mid) references member(mid);
insert into member values (1,'aaa','111','la');
insert into orders values(100,1,sysdate(),'money wire');
insert into orders(oid, mid) values (200,1);
select * from member;
select * from orders;
drop table test9;

-- foreing key 생성 시에 on delete cascade 지정
-- 부모테이블에서 레코드 삭제 -> 부모를 참고하고 있는 자식까지 한꺼번에 삭제됨
alter table orders9 add constraint order_fk3 foreign key(mid) references member9(mid) on delete cascade;
delete from member9 where mid=3; -- order까지 삭제된다



