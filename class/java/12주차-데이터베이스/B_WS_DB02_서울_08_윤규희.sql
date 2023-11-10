use scott;

-- 1. 부서정보를저장하기위한MYDEPT 테이블을생성해보자.
-- 2. DEPT 테이블의PK(DEPT_NO)를설정하는구문을추가해보자. (단, PK명은DEPT_PK로한다) -> 테이블생성시지정하기

create table mydept(
 dept_no char(8),
 dept_name varchar(100) not null,
 depte_loc varchar(100) not null,
 dept_tel_no varchar(100) not null,
 constraint dept_pk primary key(dept_no)
);

-- alter table mydept add constraint dept_pk primary key(dept_no);

-- 3. 아래의데이터를DEPT 테이블에추가해보자
insert into mydept values(10, 'sales', 'seoul','02-671-1111');
insert into mydept values(20, 'finance', 'seoul','02-862-2222');
insert into mydept values(30, 'hr', 'busan','051-111-1111');
insert into mydept values(60, 'hr', 'busan','051-111-1111');
insert into mydept values(40, 'purchase', 'busan','051-222-2222');
insert into mydept values(50, 'management', 'seoul','02-383-3333');

-- 4. 아래와 같은 데이터를 저장할 수 있도록 MYEMP 테이블을 생성해보자.
create table myemp(
 emp_no char(8),
 emp_name varchar(100) not null,
 emp_mge char(8),
 hiredate timestamp not null,
 sal int(8),
 dept_no char(8),
 constraint emp_pk primary key(emp_no)
);
-- 5. EMP 테이블의 Constaint PK(EMP_NO), FK(DEPT_NO)를 추가해보자.(단 PK는 테이블 생성 시에 지정하기, FK는 EMP_FK로 한다.)
alter table myemp
add constraint emp_fk foreign key(dept_no) references mydept(dept_no) on delete cascade;

-- 6. 4번 테이블과 같이 데이터를 추가해보자.
insert into myemp values(1001, 'kim', '1003','2005-01-15', 4750,20);
insert into myemp values(1002, 'lee', '1003','2008-06-05', 3000,30);
insert into myemp values(1003, 'park', '1003','2007-11-28', 3500,10);

-- 7. HR 부서가 MANAGEMENT부서로 통합되었다. HR 부서 직원에 대한 소속 부서를 MANAGEMENT 부서로 변경해보자.(SUB-QUERY)
update myemp set dept_no = (select dept_no from mydept where dept_name='management') where dept_no=(select dept_no from mydept where dept_name='hr');

-- 8. HR 부서를 DEPT 테이블에서 삭제해보자.
delete from mydept where dept_name='hr';

-- 9. 아래의 데이터를 EMP 테이블에 추가해보자. 추가 시 입사일은 시스템의 현재일자를 자동으로 가져와서 부여하도록 하며, ‘년-월-일’의 형태로 작성해보자.
insert into myemp values(2001, 'chung', '1001',date(now()), 3000,50);