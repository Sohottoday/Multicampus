create user jdbctest identified by jdbctest;
grant connect, resource to jdbctest;

start c:/unico/data.sql


select * from emp;




SELECT ename, REGEXP_REPLACE(sal, '[0-3]', '*') as SALARY
FROM emp; 


SELECT ename, job, sal, RANK() over (ORDER BY sal DESC) 순위
FROM emp;


SELECT ename, job, sal, RANK() over (ORDER BY sal DESC) 순위
FROM emp 
WHERE job in ('ANALYST','MANAGER'); 


SELECT ename, sal, job, RANK() over (PARTITION BY job
                                     ORDER BY sal DESC) as 순위
FROM emp;       

SELECT job, ename, sal, DENSE_RANK() OVER (PARTITION BY job
                                           ORDER BY sal DESC) 순위
FROM emp
WHERE hiredate BETWEEN to_date('1981/01/01','RRRR/MM/DD') 
                       AND to_date('1981/12/31','RRRR/MM/DD');  --입사년도가 81년도인 사람들에 대한 랭크
    -- DENSE_RANK와 RANK의 차이점은 중복순위가 있더라도 1씩 증가시킴 / ex) 2등이 2명이어도 1,2,3등. RANK는 2등이 2명이면 1,2,4

SELECT ename, job, sal, RANK() over (ORDER BY sal DESC) AS RANK,
                        DENSE_RANK() over (ORDER BY sal DESC) AS DENSE_RANK
FROM emp 
WHERE job in ('ANALYST','MANAGER');


SELECT DENSE_RANK(2975) within group (ORDER BY sal DESC) 순위
FROM emp;


SELECT DENSE_RANK('81/11/17') within group (ORDER BY hiredate ASC) 순위
FROM emp;



SELECT ename as 이름, EXTRACT(year from hiredate) as 년도, 
                              EXTRACT(MONTH from hiredate) as 달,
                              EXTRACT(day from hiredate) as 요일
FROM emp;       -- 날짜정보를 뽑아낼 수 있다.



SELECT ename, sal, RANK() over (order by sal desc) as RANK ,
                   DENSE_RANK() over (order by sal desc) as DENSE_RANK,
                   CUME_DIST()  over (order by sal desc) as CUM_DIST    -- CUM_DIST (누적 분포함수, 상위 몇%인지)
FROM emp;

SELECT job, ename, sal, RANK() over ( partition by job
                                      order by sal desc) as RANK ,
                            CUME_DIST() over ( partition by job
                                      order by sal desc) as CUM_DIST
FROM emp;


SELECT deptno, LISTAGG(ename,',') within group (order by ename) as EMPLOYEE
FROM emp
GROUP BY deptno;    --LISTAGG => 리스트들을 합침 따라서, deptno로 그룹화하여 ename을 기준으로 ,로 구분하여 묶어라.


SELECT job, LISTAGG(ename,',') within group (ORDER BY ename desc) as employee
FROM emp
GROUP BY job;   --위와 똑같은 형식이지만 order by절을 내림차순으로 구성했다.


SELECT job, 
       LISTAGG(ename||'('||sal||')',',') within group (ORDER BY ename asc) as employee
FROM emp
GROUP BY job;   -- 똑같은 형식이지만 결합 연산자를 통해 이름과 월급을 같이 나타내려 한다. 즉, 복잡한 출력

SELECT empno, ename, sal,  
         LAG(sal,1) over (order by sal asc) "전 행의 sal값",    -- LAG는 값 하나를 밀어낸 것(이전 행 값)
         LEAD(sal,1) over (order by sal asc) "다음 행의 sal값"   --LEAD는 값 하나를 당겨온 것(다음 행 값)
FROM emp;


SELECT empno, ename, hiredate,
          LAG(hiredate,1) over (order by hiredate asc) "전 행의 sal값",
          LEAD(hiredate,1) over (order by hiredate asc) "다음 행의 sal값"
FROM emp;


SELECT deptno, empno, ename, hiredate,
          LAG(hiredate,1) over ( partition by deptno
                                       order by hiredate asc) "전 행의 sal값",
          LEAD(hiredate,1) over ( partition by deptno
                                        order by hiredate asc) "다음 행의 sal값"
FROM emp;   --부서별로 나눈 다음 값을 밀고 당김.

SELECT SUM(DECODE(deptno, 10, sal)) as "10",
       SUM(DECODE(deptno, 20, sal)) as "20",
       SUM(DECODE(deptno, 30, sal)) as "30"
FROM emp;


SELECT SUM(DECODE(job,'ANALYST',sal)) as "ANALYST",
          SUM(DECODE(job,'CLERK',sal))  as "CLERK",
          SUM(DECODE(job,'MANAGER',sal)) as "MANAGER",
          SUM(DECODE(job,'SALESMAN',sal)) as "SALESMAN"
FROM emp;   --행단위가 아닌 열단위로 붙이고자 할 때에는 DECODE함수 활용.



SELECT job, sum(sal)
FROM emp
GROUP BY ROLLUP(job);   -- ROLLUP => 전체 합계도 출력.

SELECT deptno, job, sum(sal)
FROM emp
GROUP BY ROLLUP(deptno, job);   -- deptno 별로도 합계 출력하고 전체도 출력

SELECT job, sum(sal)
FROM emp
GROUP BY CUBE(job);

SELECT deptno, job, sum(sal)
FROM emp
GROUP BY CUBE(deptno,job);  -- ROLLUP 보다 조금 더 상세하게 나타내줌. 변수가 하나일때에는 큰 차이가 없다.

SELECT deptno, job, sum(sal)
FROM emp
GROUP BY GROUPING SETS(deptno, job);    --괄호 안에 나열된 컬럼 기준으로만 진행.

SELECT deptno, job, sum(sal)
FROM emp
GROUP BY GROUPING SETS(deptno, job, () );   --빈괄호를 하나 주면 전체에 대한 것을 의미.

SELECT deptno, job, sum(sal)
FROM emp
GROUP BY GROUPING SETS(deptno, job, (deptno, job), () );

SELECT empno, ename, sal, RANK() OVER (ORDER BY sal DESC) RANK,
                                     DENSE_RANK() OVER (ORDER BY sal DESC) DENSE_RANK,
                                     ROW_NUMBER() OVER (ORDER BY sal DESC) 번호
FROM emp;   --넘버링 하는 함수 ROW_NUMBER() 행 넘버를 붙이라는 뜻


SELECT empno, ename, sal, ROW_NUMBER() OVER (ORDER BY sal DESC) 번호
FROM emp
WHERE deptno = 20;

SELECT deptno, ename, sal, ROW_NUMBER() OVER( PARTITION BY deptno
                                                                   ORDER BY sal DESC) 번호
FROM emp
WHERE deptno in (10,20);

SELECT ROWNUM, empno, ename, job, sal
FROM emp
WHERE ROWNUM <= 5;

SELECT ROWNUM, empno, ename, job, sal
FROM emp
WHERE ROWNUM <= 5
ORDER BY sal;


WITH salemp AS(SELECT *
            FROM emp
           ORDER BY sal)
SELECT empno, ename, job, sal
  FROM salemp
WHERE ROWNUM <= 5;  --월급 적은 순으로 소팅을 한 다음 진행하라는 의미.


SELECT ROWNUM, empno, ename, job, sal
FROM emp
WHERE ROWNUM >= 3 AND ROWNUM <= 5
ORDER BY sal;       --결과집합에 포함이 되어야 ROWNUM이 1,2,3 진행하는건데(행단위로 결과값이 나와야 ROWNUM이 부여된다는 의미)
                    --where절에서 3보다 큰 값을 뽑아낸다고 하기 때문에 ROWNUM이 1에서 계속 머물러 있으므로 진행이 되지 않는다.


WITH salemp AS(SELECT rownum sortno, empno, ename, job, mgr, hiredate, sal, comm, deptno
            FROM (SELECT *
                      FROM emp
                      ORDER BY sal))
SELECT empno, ename, job, sal
  FROM salemp
WHERE sortno >= 3 AND sortno <= 5;  --ROWNUM이 3에서 5 사이의 값을 뽑기 위해서는 이와 같은 형식으로 이중으로 진행하여야 한다.
                    --단 첫번째 구문에서 ROWNUM은 AS해줘야 한다.(이름을 따로 지정해줘야함. 그래야 두번째 구문에서 조건을 줄 수 있기 때문)
                    --물론 이러한 형식은 Oracle에서만 이렇다. MySQL이나 다른 SQL 프로그램들은 따로 지원하는 함수가 존재.

SELECT empno, ename, job, sal
  FROM (SELECT rownum sortno, empno, ename, job, mgr, hiredate, sal, comm, deptno
            FROM (SELECT *
                      FROM emp
                      ORDER BY sal))
WHERE sortno >= 3 AND sortno <= 5;




SELECT rpad(' ', level*3)  || ename  as  employee , level, sal, job
  FROM emp
  START WITH ename='KING'
  CONNECT BY prior empno = mgr;     --계층적 트리구조형식을 적용시켜 출력하고자 할 때 사용하는 함수. START WITH, CONNECT BY prior
    --RPAD로 들여쓰기 효과를 줘서 눈에 잘 보이게 하는것도 좋다.


SELECT rpad(' ', level*3)  || ename  as  employee , level, sal, job
  FROM emp
  START WITH ename='KING'
  CONNECT BY prior empno = mgr AND ename != 'BLAKE';



SELECT rpad(' ', level*3)  || ename  as  employee , level, sal, job
  FROM emp
  START WITH  ename='JONES'
  CONNECT BY prior empno = mgr ;
  

SELECT ename, SYS_CONNECT_BY_PATH(ename,'/')  as  path 
  FROM emp
  START WITH ename='KING'
  CONNECT BY prior empno = mgr;

SELECT ename, LTRIM(SYS_CONNECT_BY_PATH(ename,'/'), '/')  as  path 
  FROM emp
  START WITH ename='KING'
  CONNECT BY prior empno = mgr;




