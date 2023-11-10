show databases;
use scott;

select empid, fname, lname, email
from emp;

select deptid, deptname
from dept;

select * from emp;

select locid, city, countryid from loc;
select distinct jopid from emp; -- 중복 데이터 삭제) all을 사용하면 중복값 나옴

select distinct deptid from emp;

select * from emp order by hdate ASC;

select empid,fname,deptid,salary from emp order by 3 asc; -- 3번째인 deptid로 오름차순

select empid 사번, lname 이름, salary 연봉, salary* 0.3 본너스 from emp; -- 별칭 주기

select empid,fname,hdate from emp where hdate < '2005-05-05' order by hdateCITYSTATE asc;
select * from loc;

select city from loc where countryid = "US";
select * from emp;

select fname from emp where salary > 4000 and deptid=60;

select distinct fname from emp where deptid=30 or deptid=20;

select distinct * from emp where salary >= 9000 and salary <= 12000;
select empid,fname,lname from emp where empid in (129,139,149);
select * from emp where hdate between '2004-01-01' and '2004-10-14';
select * from loc;
select city from loc where countryid in ('US', 'IT');
select * from emp where fname like 'A%'; -- A로 시작하는 이름 검색

select * from emp where phone like '10%';
select * from emp where fname like '%a%';
select * from emp where fname like 'ad__'; -- ad로 시작하고 뒤에 두 글자가 아무거나 있는 사람
select * from emp where comm is null;
select * from emp where comm >= 0.3 order by comm desc;
select * from emp where deptid is null;
select * from emp where mgrid is null;
select distinct * from emp where salary>=7000 and deptid is not null;

select count(empid), count(deptid) from emp;
select max(salary) 최고연봉, min(salary) 최저연봉 from emp;


select round(avg(salary), 2) from emp where deptid = 50;

select empid , concat(fname,lname) from emp;

select * from scott.emp;

select fname, replace(fname, 'a', 'x') from emp;

select fname, substring(fname, 1, 2) from emp;

select ucase(fname), lacase(fname), reverse(fname) from emp;

-- 날짜 관련 함수
select now() now, sysdate() sysdate, curdate() curdate, current_timestamp() from emp;

select fname, hdate, year(hdate), month(hdate), monthname(hdate), dayname(sysdate()), weekday(now()), dayofweek(now()) from emp;

select date_format(now(), '%Y') 연도,date_format(now(), '%M') 월,date_format(now(), '%D')일; 

select fname, salary, format(salary,2) from emp; 
select avg(salary), deptid from emp;

select avg(salary) , deptid from emp group by jobid;
select fname, salary,format(salary,2);
select avg(salary), deptid from emp;

-- groupby 그룹을 나눠서 작업하는 경우 select절의 컬럼들은 alter
-- 집계함수를 제외하고 모두 group by 절에 표시가 되어야함

-- 50번 이상의 부서를 대상으로 부서별 연봉 평균을 구하기(평균금액, deptid)
-- 연봉 평균이 9000 이상인 레코드만

-- 부서별 인원이 3명 이상인 부서의 부서번호, 인원수, 급여 총액 출력


select round(avg(salary),1), deptid from emp where deptid>= 50 group by deptid having avg(salary) > 9000;
select max(salary), fname, jobid from emp;

select deptid,count(*),sum(salary) from emp group by deptid having count(*)>=3 order by deptid;
