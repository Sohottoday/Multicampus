--제출파일명 : exercise3.sql
-- scott_create_table.sql 을 복사하여 scott 계정 영역에서 수행시키고 
-- course1 과 couse2 테이블을 생성한 후에 진행한다.

-- 1. 집합연산자 실습 

-- 1.1 course1 과 course2 를 모두 수강하는 학생들의 이름, 전화 번호 그리고 
--    나이를 출력하시오.
select * from course1
intersect
select * from course2;
  
-- 1.2 course1 이든 course2 든 수강하는 학생들의 이름, 전화 번호 그리고 
--    나이를 출력하는데 나이가 많은 순으로 출력하시오.
select  name, phone, age from course1
union 
select name, phone, age from course2 order by age;

-- 1.3 course1은 수강하지만 course2 는 수강하지 않는 학생들의 이름을 출력하시오.
select * from course1
minus
select * from course2;
  
-- 1.4 course2는 수강하지만 course1 은 수강하지 않는 학생들의 이름과 전화번호를 
--    이름 순으로 출력하시오.

select * from course2
minus
select * from course1 order by 1;
  
  
--2. 모든 직원들 월급의 평균을 구하시오. 
--       (소수점 이하 둘째자리까지만 나타내고 셋째자리 부터는 절삭하시오)


--	월급 평균
 --              -----------
--	   x

select trunc(avg(sal),2) as 월급평균 from emp;

--3. 모든 직원들이 받는 커미션의 합을 구하시오.
--	커미션 합
               -----------
--	  x

select sum(comm) as 커미션합 from emp;


--4. 각 직급별로 총월급을 출력하되 총월급이 낮은 순으로 출력하시오.

--	직급명	총월급
--	----------------------------
--	xxxx          xxx
--	 :	   :
--
select JOB as "직급명" , SUM(SAL) as "총월급" from emp
GROUP BY JOB
ORDER BY 총월급;

--5. 각 부서에서 근무하는 직원들의 명수를 알고싶다. 다음 형식으로 출력하는 SQL
--    을 작성하시오 .

--	부서정보	   직원명수
--	----------------------------
--	미정          1명
--	30번 부서   6명
--	20번 부서   4명
--	10번 부서   3명

SELECT CASE DEPTNO
    WHEN 10 THEN '10번 부서'
    WHEN 20 THEN '20번 부서'
    WHEN 30 THEN '30번 부서'
    ELSE '미정'
END AS "부서정보", COUNT(ENAME) as "직원명수" FROM EMP
GROUP BY DEPTNO;


--6. 년도별로 몇명이 입사했는지 알고싶다. 다음 형식으로 출력하는 SQL
--    을 작성하시오 . (많이 입사한 순으로 출력)

--	입사년도 	   입사 인원수
--	----------------------------
--	1981년	   10명
--	1987년	   2명
--	1982년	   1명
--	1980년	   1명

select to_char(hiredate, 'yyyy"년"') as 입사년도, count(*) as 입사인원수 from emp 
group by to_char(hiredate, 'yyyy"년"')
order by to_char(hiredate, 'yyyy"년"') desc;

--7. 전체 직원들의 숫자를 부서정보를 다음 형식으로 출력하는 SQL
--    을 작성하시오 .

--	2019년 12월 27일 기준으로 14명이 근무중입니다.

select to_char(sysdate, 'yyyy"년" mm"월" dd"일 기준으로"') || count(ename) || '명이 근무중입니다' as result from emp;

--8. 직급별 총월급을 출력하되, 직급이 'MANAGER'인 직원들은 제외하시오. 
--   그리고 그 총월급이 5000보다 큰 직급와 총월급만 출력하시오.

--	직급명	총월급
--	----------------------------
--	xxxx          xxx
--	 :	   :
select job as 직급명, sum(sal) as 총월급 from emp 
where job != 'MANAGER'
group by job HAVING sum(sal) >5000;

--9. 30번 부서의 업무별 년봉의 평균을 검색한다.
-- 연봉계산은 월급+커미션(null이면 0으로 계산)이며 
-- 출력 양식은 소수점 이하 두 자리(반올림)까지 통일된 양식으로 출력한다.
 --             업무명       평균월급
 --             ---------------------------
--              xxxx         xxx.xx
--	 :	    :
--select job , sal, comm, nvl2(comm, sal + comm, sal) from emp where deptno = '30';

SELECT DEPTNO AS "업무명", ROUND(AVG(SAL+NVL(COMM,0)),2) FROM EMP
GROUP BY DEPTNO
HAVING DEPTNO = 30;

--select job as 업무명, to_char(avg(nvl2(comm, sal + comm, sal)), '999,999.00')  as 평균월급 from emp 
--where deptno = '30' 
--group by job;
--10. 월별 입사인원을 다음 형식으로 출력하는 SQL 을 작성하시오 . 
--     입사월별로 오름차순이며 입사인원이 2명 이상인 경우에만 출력한다.


--	02월	2명
--	04월	2명
--	05월	2명
--	09월	2명
--	12월	3명

select to_char(hiredate, 'mm"월"')as 입사월, count(ENAME) || '명' as 입사인원 from emp 
group by to_char(hiredate, 'mm"월"')
HAVING COUNT(ENAME)>=2
order by 입사월;



  