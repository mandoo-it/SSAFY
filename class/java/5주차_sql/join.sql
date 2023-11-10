-- view
use scott;
create or replace view v_sales as select * from emp where jobid like 'SA%';
select * from v_sales;

create view dept50 as select empid, fname, deptid, phone from emp where deptid >= 50;

use tommy;
create view ep3 as select characterid, realname from casting where episodeid = 3;
select * from ep3;

select count(*) from dept50;
insert into dept50 values(888,'willy',30,'0200303');

select max(salary) ,fname from emp; -- mysql에서만 된당.

select count(*)
from emp
where salary>=(select avg(salary) from emp);

select * from scott.emp;
-- 조인
select e.empid, e.fname, e.deptid, d.deptname 
from emp e, dept d 
where e.deptid = d.deptid 
order by 1;

-- empid, fnmae, jobid,jobtitle
select e.empid ,e.fname, j.jobid, j.jobtitle
from emp e, job j
where e.jobid = j.jobid
order by 1;

select d.deptid, d.deptname,l.city
from dept d, loc l
where d.locid = l.locid
order by 1;

create or replace view emp3 as select e.empid, e.fname, d.deptname,j.jobtitle, l.city
from emp e, dept d, job j, loc l
where e.deptid = d.deptid
and e.jobid = j.jobid and d.locid = l.locid;

select * from emp3 limit 5;

create index email_idx on emp (email);

-- transaction
select * from scott.test;
insert into test values(1, 'a');
-- tx 시작
start transaction;
insert into test values(3,'a');
insert into test values(4,'a');
rollback;
