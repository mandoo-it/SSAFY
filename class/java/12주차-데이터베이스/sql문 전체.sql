use scott;
desc emp;
select empid, fname from emp;

select * from emp;
select distinct deptid from emp;

-- 부서별 사원, 이름 , 연봉, 입사일, 인원수
-- (인원수가 3명 이상인 50번이상인 부서 대상, 인원 순으로 내림차순)
select empid, fname, salary, hdate, count(*)
from emp
where deptid >= 50
group by deptid
having count(*) >= 3
order by 5 desc;

-- in, between, is(null 비교), like
-- 부서번호가 20, 40, 60인 레코드
select * from emp 
where deptid in(20, 40, 60); -- in 안쓰면 where deptid>= 20 이런식으로 써야함

-- 연봉이 15000에서 20000사이
select * from emp where salary between 15000 and 20000;

-- 입사일이 2005-01-25에서 2009-12-12사이 레코드-
select * from emp where hdate between '2005-01-25' and '2009-12-12';

-- 이메일이 E로 시작
select * from emp where email like 'E%';

-- commision을 받지 않는 직원들
select * from emp where comm is null;

-- 10,20,30,40 이외의 부서에 속한 직원 정보
select * from emp where deptid not in(10,20,30,40);

-- 함수 : 숫자관련, 문자, 날짜 관련 ,집계함수
-- 집계함수 : sum(), avg(), count(), max(), min()

-- 제일 높은 연봉 금액
select max(salary) from emp;

-- 50번 부서 연봉 평균
select fname, min(salary) from emp;

-- 각 부서별 연봉 평균(소수점없이) : 부서id, 평균금액, 높은 순을 정렬a
select deptid 부서, round(avg(salary),0) 평균 from emp where deptid is not null group by deptid having round(avg(salary),0) >= 10000 order by round(avg(salary),0) desc;

-- 문자열 결합: concat()
-- 사번 설명
-- 100 Steven KIng is a manager
select empid, concat(fname, ' ', lname, ' is a ', jobid) 설명
from emp;

select empid, fname, substring(fname, 1, 2) from emp;

-- 날짜 관련 함수
select now(), sysdate(), curdate(), curtime();
select year(now()), month(noew()), monthname(now()), dayofweek(now());

-- empid, fname+lname, hdate, 근속년수, 근속년수 많은 순, 근속년수 같으면 사번 순으로 정렬
select empid, concat(fname, lname) 이름, hdate, year(now()) - year(hdate) 근속년수
from emp
order by 4 desc ,empid asc;

-- null값 체크하는 함수
select comm, if(comm, 1, 0), ifnull(comm, 'none') from emp;

-- comm을 받으면 그 값의 2배를 출력(alias 새 커미션), 받지 않으면 "받지 않음" 출력
select comm, ifnull(comm * 2, '받지 않음') "새 커미션"
from emp;

-- emp테이블에서 모든 jobid(중복값 제거)
select distinct jobid from emp;

-- 결과 확인하기 -> 300
select '100'+'200';

-- 결과 확인하기 -> {"empid": 100, "fname": "Steven"}
select json_object('fname', fname, 'empid', empid) as json from emp;

-- '2003'일 이후 입사자
select * from emp where hdate > '2003-01-03';

-- jobid별 연봉 평균, 연봉 합계(소수점 1자리까지 표시, 연봉 높은 순 정렬)
select jobid,round(avg(salary),0) , sum(salary) from emp group by jobid order by 2 desc; 

-- 연봉 높은 순으로 상위 5명
select * from emp order by salary desc limit 5; 

-- 부서별, jobid별 연봉 평균
select deptid, jobid, avg(salary) from emp where deptid is not null group by jobid,deptid  order by 3 desc; 
-- 부서번호가 30이거나 연봉이 15000이상인 레코드

-- 1. emp 테이블에서 모든 jobid(중복값 제거)
select distinct jobid
from emp;

-- 2. 결과
select '100'+'200';

-- 3. 결과
select json_object('사번', fname, '이름', empid) as json
from emp;
-- 4. '2003-01-03'일 이후 입사자
select *
from emp
where hdate > '2003-01-03';

-- 5. jobid별 연봉 평균, 연봉 합계(소수점 1자리까지 표시, 연봉 높은 순 정렬)
select jobid, round(avg(salary),1) "연봉 평균", sum(salary) "연봉 합계"
from emp 
group by jobid
order by 1 desc;

-- 6. 연봉 높은 순으로 상위 5명
select * 
from emp
order by salary desc
limit 5;

-- 7. 부서별, jobid별 연봉 평균 
-- (부서 id, jobid, 연봉 평균액 출력, 연봉 순 정렬, 부서번호가 null인 데이터 제외)
select deptid, jobid, avg(salary)
from emp
where deptid is not null
group by deptid, jobid
order by 3;

-- 8. 부서 번호가 30이거나 연봉이 15000이상인 레코드
select *
from emp
where deptid = 30 or salary>=15000;

-- 9. 전화번호가 590으로 시작하는 레코드
select *
from emp
where phone like '590%';

-- 10. 커미션을 받는 사람들을 입사일 순으로 정렬
select *
from emp
where comm is not null
order by hdate;

-- 11. 부서번호가 null이 아닌 직원 중 사번, 이름, 연봉, 보너스(연봉*0.3)값을 출력
-- (컬럼 헤딩(alias)은 사번, 이름, 연봉, 보너스로 한다)
select empid 사번, fname 이름, salary 연봉, salary*0.3 보너스
from emp
where deptid is not null;

-- 12. 부서 ID가 40번이 아닌 부서에 속한 직원들 중 salary가 20000이상인 레코드
select *
from emp
where deptid != 40 and salary>=20000;

-- 13. jobid가 'ST_CLERK', 'SA_MAN', 'SA_REP'인 직원의 id와 이름, jobid
select empid, fname, jobid
from emp
where jobid in ('ST_CLERK', 'SA_MAN', 'SA_REP');

-- 14. 결과
select deptid, case deptid
when 30 then 'Seattle'
when 40 then 'Newyork'
when 50 then 'LA'
else 'Washington'
end address
from emp;

-- DDL
-- MYMEMBER(회원정보) : 부모테이블
create table mymember(mid varchar(20) primary key, name varchar(20) not null, address varchar(30) not null);
-- MYORDER(주문정보) : 자식테이블
-- 제약조건 : primary key(not null+unique), not null, foreign key(참조키, null 가능), check table
-- 데이터 추가 : 부모먼저 자식 나중
-- 데이터 삭제 : 자식 먼저 부모 나중

create table myorder(
oid varchar(20) primary key,
mid varchar(10), -- fk
odate timestamp default current_timestamp, -- default값을 현재 시간으로
payment varchar(18) default 'money wire' not null,
constraint pcheck check(payment in('credit card''money wire', 'point')) -- 제약조건 추가 (pcheck : 제약조건 이름 / payment의 값은 셋 중 하나여야한다.) -- insert할 때 세가지 값이 아닌 다른 값을 쓰려고 하면 에러가 난다. 
);

-- fk(on delete cascade 옵션 지정 : 부모 테이블에서 레코드 삭제시 자식레코드까지 모두 삭제됨)
alter table myorder
add constraint myorder_fk foreign key(mid) references mymember(mid) on delete cascade;

insert into mymember values(100, 'tom', 'la');
insert into myorder values(1, 100, null, 'point');
insert into myorder(oid, mid, payment) values(2, 100, 'credit card');
insert into myorder(oid, mid) values (3,100);
insert into myorder(oid, mid, payment) values(4, 100, 'mileage');
select * from mymember;
select * from myorder;

delete from mymember where mid = 100;

drop table mymember, myorder; -- mysql에서만

-- join(inner join) : pk, fk로 연결해서 join
select e.empid, e.fname, d.deptname
from emp e , dept d
where e.deptid = d.deptid;

select count(*) from emp;

-- ansi 표준에 의한 조인 문법
select e.empid, e.fname, d.deptname
from emp e inner join dept d
on e.deptid = d.deptid;

-- empid, fname, jobid, jobtitle (조인 방법1)
select e.empid, e.jobid, j.jobtitle
from emp e join job j
on e.jobid = j.jobid;

-- empid, fname, deptname, jobtitle (조인 방법 2)
select e.empid, e.jobid, d.deptname, j.jobtitle
from emp e, dept d, job j
where e.deptid = d.deptid and e.jobid = j.jobid;

-- empid, fname, deptid, deptname(부서가 없는 레코드도 출력)
-- outer join
select e.empid, e.fname, d.deptid, d.deptname
from emp e left outer join dept d
on e.deptid = d.deptid;

-- self join
-- empid, fname, 자신의 매니저이름
select e1.empid, e1.fname, e2.fname
from emp e1 , emp e2
where e1.mgrid = e2.empid;

-- empid, fname, 자신의 매니저이름(매니저 없는 사람까지 나오게)
select e1.empid, e1.fname, e2.fname
from emp e1 left join emp e2
on e1.mgrid = e2.empid;

-- 연봉이 15000-2000사이의 레코드를 대상으로 사번, 이름, 연봉, 부서명, 업무명(jobtitle)
select e.empid, e.fname, e.salary, d.deptname, j.jobtitle
from emp e, job j, dept d
where e.deptid = d.deptid and e.jobid = j.jobid and e.salary between 15000 and 20000;  
-- fname이 'Alexandaer'인 직원의 부서명 
select d.deptname, e.fname
from emp e, dept d
where e.deptid = d.deptid and e.fname = 'Alexander';
-- 부서별 도시 이름
select d.deptname, l.city
from dept d, loc l
where d.locid = l.locid;

-- 자신의 jobid별 최저/최고 
select e.fname, e.salary, j.minsal , j.maxsal
from emp e, job j
where e.jobid = j.jobid;

-- 부서별 부서이름, 인원수 많은 순으로 정렬(부서id, 부서명, 인원수)
select d.deptname, d.deptid, count(*) cnt
from emp e, dept d
where e.deptid is not null and e.deptid = d.deptid group by deptid, deptname order by cnt desc, e.deptid;

-- subquery
-- 연봉이 제일 낮은 직원의 사번, 이름, 연봉
select empid, fname, salary from emp where salary = (select min(salary) from emp);

-- 116번 사원과 동일한 업무를 하는 직원의 정보
select * from emp where jobid = (select jobid from emp where empid = 116);

-- state 정보가 없는 부서의 id, 부서명, locid
select deptid, deptname, locid from dept where locid in (select locid from loc where state is null); -- 서브쿼리의 데이터가 여러개면 in (그래서 모르겠으면 in을 쓰는게 안전)

-- 회사 전체 평균 연봉보다 많이 받는 직원 정보
select * from emp where salary > (select avg(salary) from emp);

-- Southlake에 있는 부서id, 부서이름
-- select deptid, deptname from dept d join loc l on d.locid = l.locid and l.city = 'Southlake';
select deptid, deptname from dept where locid = (select locid from loc where city = 'Southlake' );

-- 50번 부서 평균 연봉보다 많이 받는 직원 정보
select * from emp e where salary > (select avg(salary) from emp where deptid = 50);

-- 미국에 근무한느 직원들의 평균 연봉
select avg(salary) from emp where deptid in (select deptid from dept where locid in (select locid from loc where countryid='US'));

-- view(가상테이블 : view를 만들기위해 작성한 쿼리문만 저장되어있음)
-- 보안상의 이유, 복잡한 쿼리 사용을 대신하기 위해서

create view emp_other as select * from emp where deptid > 40;

