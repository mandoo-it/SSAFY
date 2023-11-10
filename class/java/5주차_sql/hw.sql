-- 1) emp 테이블 정보의 구조를 확인하는 sql을 작성 하세요
desc emp;
-- 2) 이름이 K로 시작하는 사원의 사원번호, 이름, 입사일, 급여를 검색하세요.
select empno,ename,hiredate,sal from emp where ename like 'K%';

-- 3)입사일이 2000년도인 사람의 모든 정보를 검색하세요.
select * from emp where year(hiredate) = 2000;

-- 4) 커미션이 NULL이 아닌 사람의 모든 정보를 검색하세요.
select * from emp where comm is not null;

-- 5) 부서가 30번 부서이고 급여가 $1,500 이상인 사람의 이름, 부서 ,월급을 검색하세요.
select ename,deptno,sal from emp where sal > 1500 and deptno = 30;

-- 6) 부서번호가 30인 사람 중 사원번호 SORT하여 출력되도록 검색하세요.
select * from emp where deptno = 30 order by empno asc;

-- 7) 급여가 많은 순으로 SORT하여 출력되도록 검색하세요
select * from emp order by sal desc;

-- 8) 부서번호로 ASCENDING SORT한 후 급여가 많은 사람 순으로 검색하세요
select * from emp order by deptno asc , sal desc;

-- 9) 부서번호가 DESCENDING SORT하고, 이름 순으로 ASCENDING SORT, 급여 순으로 DESCENDING SORT 하여 출력되도록 검색하세요.
select * from emp order by deptno desc, ename asc , sal desc;

-- 10) emp Table에서 이름, 급여, 커미션 금액, 총액(급여+커미션금액)을구하여 총액이 많은 순서로 검색하세요. 단, 커미션이 NULL인사람은 제외한다.(커미션금액: sal*comm/100)
select ename 이름, sal 급여, (sal*comm/100) '커미션 금액' ,(sal+sal*comm/100) 총액 from emp where comm is not null order by 총액  desc;

-- 11) 10번 부서의 모든 사람들에게 급여의 13%를 보너스로 지불하기로하였다. 이름, 급여, 보너스 금액, 부서번호를 검색하세요
select ename 이름, sal 급여, (sal*0.13) 보너스, deptno 부서번호 from emp where deptno = 20;

-- 12) 부서번호가 20인 사원의 시간당 임금을 계산하여 검색하세요.
-- 단, 1달의 근무일수는 12일이고, 1일 근무시간은 5시간이다.
-- 출력양식은 이름, 급여, 시간당 임금(소수이하 첫 번째 자리에서 반올림)을 검색하세요.
select ename 이름, sal 급여, round((sal / 12 / 5)) '시간당 임금' from emp where deptno = 20;
-- 13) 급여가 $1,500부터 $3,000 사이의 사람은 급여의 15%를 회비로 지불하기로 하였다. 이를 이름,
-- 급여, 회비(소수점 두자리아래에서 반올림)를 검색하세요.
select ename 이름, sal 급여, round((sal * 0.15), 2) '회비' from emp where sal >= 1500 and sal <= 3000;
-- 14) 모든 사원의 실수령액을 계산하여 검색하세요.. 단, 급여가 많은 순으로 이름, 급여, 실수령액을
-- 검색하세요..(실수령액은 급여에 대해 10%의 세금을 뺀 금액)
select ename 이름, sal 급여, round(sal - sal*0.1) '실수령액' from emp order by sal desc;
-- 15) 이름의 글자수가 6자 이상인 사람의 이름을 앞에서 3자만 구하
-- 여 소문자로 이름만을 검색하세요.
select lower(left(ename,3)) 이름 from emp where length(ename)>=6;
-- 16) 10번 부서 월급의 평균, 최고, 최저, 인원수를 구하여 검색하세요.
select avg(sal) 월급, max(sal),min(sal), count(*) from emp where deptno = 10;
-- 17) 각 부서별 같은 업무를 하는 사람의 인원수를 구하여 부서번호,업무명, 인원수를 검색하세요.
select deptno, job, count(job) from emp group by deptno, job;
 -- 17) 각 부서별 같은 업무를 하는 사람의 인원수를 구하여 부서번호,업무명, 인원수를 검색하세요.
select deptno, job, count(job) from emp group by deptno, job;
-- 18) 같은 업무를 하는 사람의 수가 4명 이상인 업무와 인원수를 검색하세요.
select job, count(job) 인원수 from emp group by job having count(job) >=4;
-- 19) 입사일로부터 오늘까지의 일수를 구하여 이름, 입사일, 근무일수를 검색하세요
select ename, hiredate , datediff(curdate(), hiredate) 근무일수 from emp;
-- 20) 직원의 이름, 근속년수를 구하여 검색하세요
select ename, (year(sysdate())-year(hiredate)) 근속년수 from emp;


