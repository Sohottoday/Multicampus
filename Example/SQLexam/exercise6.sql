--QUESTION
--제출파일명 : exercise6.sql
--모두 서브쿼리를 사용해서 해결합니다.

-- 1. 'DALLAS'에서 근무하는 직원의 이름, 직위, 부서번호를 출력하시오.
--이름         직위         부서번호              
---------- --------- ----------
--SCOTT	   ANALYST	20
--SMITH	   CLERK		20
--JONES	   MANAGER	20
--FORD	   ANALYST	20

SELECT ENAME AS "이름", JOB AS "직위", DEPTNO AS "부서번호"
FROM EMP
WHERE DEPTNO =any (SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS');

--2. 'SMITH'보다 월급을 많이 받는 직원들의 이름과 월급 그리고 부서명을 출력한다.
--직원명               급여             부서명         
---------- ---------- ------------
--SCOTT		3000	RESEARCH
--ALLEN		1600	SALES
--WARD		1250	SALES
--JONES		2975	RESEARCH
--MARTIN	1250	SALES
--BLAKE		2850	SALES
--CLARK		2450	ACCOUNTING
--KING		5000	ACCOUNTING
--TURNER	1500	SALES
--JAMES		950	SALES
--FORD		3000	RESEARCH
--MILLER		1300	ACCOUNTING

SELECT E.ENAME AS "직원명", E.SAL AS "급여", D.DNAME AS "부서명"
FROM EMP E JOIN DEPT D ON(E.DEPTNO = D.DEPTNO)
WHERE E.SAL > (SELECT SAL FROM EMP WHERE ENAME = 'SMITH');

--3. 30번 부서의 직원들과 동일한 해에 입사한 직원들의 이름, 월급, 
--   부서번호 그리고 입사년도를 출력한다.(30번부서 제외하고)
--Ename        Sal            DeptNo         HireYear
---------- ---------- ---------- ----------
--FORD	   3000	       20		1981
--KING	   5000	       10		1981
--CLARK	   2450	       10		1981
--JONES	   2975	       20		1981

SELECT ENAME, SAL, DEPTNO, TO_CHAR(HIREDATE, 'YYYY') AS "HireYear"
FROM EMP
WHERE TO_CHAR(HIREDATE, 'YYYY') = ALL (SELECT TO_CHAR(HIREDATE, 'YYYY') FROM EMP WHERE DEPTNO = 30)
AND DEPTNO != 30;

--4. 'BLAKE'와 같은 부서에 있는 직원들의 이름과 입사일을 뽑는데 'BLAKE'는 빼고 출력한다. 
--ENAME      HIREDATE
---------- --------
--JAMES	     81/12/03
--TURNER     81/09/08
--BLAKE	     81/05/01
--MARTIN     81/09/28
--WARD	     81/02/22
--ALLEN	     81/02/20

SELECT ENAME, HIREDATE
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME='BLAKE')
AND ENAME != 'BLAKE';

--5. 평균급여보다 많은 급여를 받는 직원들의 직원번호, 이름, 월급을
-- 출력하되, 월급이 높은 사람 순으로 출력한다.
--  EMPNO ENAME    SAL
---------- ------ ----------
--7839	KING	5,000원
--7788	SCOTT	3,000원
--7902	FORD	3,000원
--7566	JONES	2,975원
--7698	BLAKE	2,850원
--7782	CLARK	2,450원

SELECT EMPNO, ENAME, TO_CHAR(SAL,'999,999')
FROM EMP
WHERE SAL > (SELECT AVG(SAL) FROM EMP)
ORDER BY SAL DESC;

--6. 이름에 'T'를 포함하고 있는 직원들과 같은 부서에서 근무하고
--   있는 직원의 직원번호와 이름을 출력한다.
--EMPNO ENAME     
---------- ----------
--7902	FORD
--7566	JONES
--7369	SMITH
--7788	SCOTT
--7900	JAMES
--7844	TURNER
--7698	BLAKE
--7654	MARTIN
--7521	WARD
--7499	ALLEN  

SELECT EMPNO, ENAME
FROM EMP
WHERE DEPTNO = ANY (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%');

--7 급여가 평균급여보다 많고,이름에 S자가 들어가는 직원과 동일한
--  부서에서 근무하는 모든 직원의 직원번호,이름 및 급여를 출력하시오.
--EMPNO      ENAME      SAL
----------  --------  -------
--7902	     FORD	      3000
--7566	     JONES      2975
--7788	     SCOTT      3000
--7698	     BLAKE      2850

SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE SAL > (SELECT AVG(SAL) FROM EMP)
AND DEPTNO = ANY(SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%S%');

--8. 30번 부서에 있는 직원들 중에서 가장 많은 월급을 받는 직원보다
--   많은 월급을 받는 직원들의 이름, 부서번호, 월급을 출력한다. 
--   (단, ALL 또는 ANY 연산자를 사용할 것)
--  이름    부서번호   월급
--------------------------------
--JONES	20	2975
--SCOTT	20	3000
--FORD	20	3000
--KING	10	5000

SELECT ENAME AS "이름", DEPTNO AS "부서번호", SAL AS "월급"
FROM EMP
WHERE SAL >ALL (SELECT SAL FROM EMP WHERE DEPTNO = 30);

--9. SALES 부서에서 일하는 직원들의 부서번호, 이름, 직업을 출력한다.
--DEPTNO    ENAME       JOB      
---------- ---------- ---------
--30번 부서  ALLEN	       SALESMAN
--30번 부서  WARD	       SALESMAN
--30번 부서  MARTIN      SALESMAN
--30번 부서  BLAKE	       MANAGER
--30번 부서  TURNER      SALESMAN
--30번 부서  JAMES	       CLERK
 
SELECT DEPTNO||'번 부서', ENAME, JOB
FROM EMP 
WHERE DEPTNO = ALL(SELECT DEPTNO FROM DEPT WHERE DNAME='SALES');

--10. 'KING'에게 보고하는 모든 직원의 이름과 입사날짜를 출력한다. 
--     (KING에게 보고하는 직원이란 mgr이 KING인 직원을 의미함) 
--이름         입사날짜
---------- ----------
--JONES	   1981년 04월 02일
--BLAKE	   1981년 05월 01일
--CLARK	   1981년 06월 09일

SELECT ENAME AS "이름", TO_CHAR(HIREDATE,'YYYY"년" MM"월" DD"일"') AS "입사날짜"
FROM EMP
WHERE MGR = ALL (SELECT EMPNO FROM EMP WHERE ENAME = 'KING');
