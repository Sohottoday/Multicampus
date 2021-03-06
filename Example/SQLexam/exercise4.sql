-- 1. DALLAS에서 근무하는 직원의 이름, 업무, 부서이름을 출력하시오.
--이름         업무         	부서이름          
---------- --------- ------------------
--SCOTT	    ANALYST	RESEARCH
--SMITH	    CLERK		RESEARCH
--JONES	    MANAGER	RESEARCH
--FORD	    ANALYST	RESEARCH      

SELECT E.ENAME AS "이름", E.JOB AS "업무", D.DNAME AS "부서이름"
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
AND D.LOC = 'DALLAS';

-- 2. 이름에 'A'가 들어가는 직원들의 이름과 부서이름을 출력하시오.
--이름        부서이름          
--------    --------------
--ALLEN	   SALES
--WARD	   SALES
--MARTIN   SALES
--BLAKE	   SALES
--CLARK	   ACCOUNTING
--JAMES	   SALES        

SELECT E.ENAME AS "이름", D.DNAME AS "부서이름"
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
AND E.ENAME LIKE '%A%';

-- 3. 직원이름과 그 직원이 속한 부서의 부서명, 그리고 월급을 
--출력하는데 월급이 3000이상인 직원을 출력하시오. 
--직원이름   부서명               월급
---------- -------------- ----------
--SCOTT	   RESEARCH	3,000원
--KING	   ACCOUNTING	5,000원
--FORD	   RESEARCH	3,000원

SELECT E.ENAME AS "직원이름", D.DNAME AS "부서명", TO_CHAR(E.SAL,'9,999') AS "월급"
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
AND E.SAL >= 3000;

-- 4. 업무가 'SALESMAN'인 직원들의 업무와 그 직원이름, 그리고
-- 그 직원이 속한 부서 이름을 출력하시오. 
--업무          직원이름       부서이름          
--------- ---------- --------------
--SALESMAN  TURNER     SALES         
--SALESMAN  MARTIN     SALES         
--SALESMAN  WARD       SALES         
--SALESMAN  ALLEN      SALES       

SELECT E.JOB AS "업무", E.ENAME AS "직원이름", D.DNAME AS "부서이름"
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO(+)
AND E.JOB = 'SALESMAN';

-- 5. 커미션이 책정된 직원들의 직원번호, 이름, 연봉, 연봉+커미션,
-- 급여등급을 출력하되, 각각의 컬럼명을 '직원번호', '직원이름',
-- '연봉','실급여', '급여등급'으로 하여 출력하시오. 
--  직원번호 직원이름      연봉           실급여       급여등급
---------- ---------- ---------- ---------- ----------
--  7521 WARD             15000         15200          2
--  7654 MARTIN          15000         15300          2
--  7844 TURNER          18000         18000          3
--  7499	ALLEN	       19200         19500	   3

SELECT E.EMPNO AS "직원번호", E.ENAME AS "직원이름", E.SAL AS "연봉", E.SAL+E.COMM AS "실급여", S.GRADE AS "급여등급"
FROM EMP E, SALGRADE S
WHERE E.SAL+E.COMM BETWEEN S.LOSAL AND S.HISAL;

-- 6. 부서번호가 10번인 직원들의 부서번호, 부서이름, 직원이름,
-- 월급, 급여등급을 출력하시오. 
--   부서번호 부서이름           직원이름      월급           급여등급
---------- -------------- ---------- ---------- ----------
--      10 ACCOUNTING     CLARK            2450          4
--      10 ACCOUNTING     KING              5000          5
--      10 ACCOUNTING     MILLER           1300           2 

SELECT E.DEPTNO AS "부서번호", D.DNAME AS "부서이름", E.ENAME AS "직원이름", E.SAL AS "월급", S.GRADE AS "급여등급"
FROM EMP E, DEPT D, SALGRADE S
WHERE E.DEPTNO = D.DEPTNO
AND E.DEPTNO = 10
AND E.SAL BETWEEN S.LOSAL AND S.HISAL;

-- 7. 부서번호가 10번, 20번인 직원들의 부서번호, 부서이름, 
-- 직원이름, 월급, 급여등급을 출력하시오. 그리고 그 출력된 
-- 결과물을 부서번호가 낮은 순으로, 월급이 많은 순으로 정렬하시오. (7개 행)
--   부서번호 부서이름              직원이름               월급       급여등급
---------- -------------- ---------- ---------- ----------
--    10 ACCOUNTING              KING                   5000          5
--    10 ACCOUNTING              CLARK                 2450          4

SELECT E.DEPTNO AS "부서번호", D.DNAME AS "부서이름", E.ENAME AS "직원이름", E.SAL AS "월급", S.GRADE AS "급여등급"
FROM EMP E, DEPT D, SALGRADE S
WHERE E.DEPTNO = D.DEPTNO(+)
AND E.DEPTNO IN (10, 20)
AND E.SAL BETWEEN S.LOSAL AND S.HISAL
ORDER BY E.DEPTNO, E.SAL DESC;

-- 8. 사원들의 이름, 부서번호, 부서이름을 출력하시오. 
-- 단, 직원이 없는 부서도 출력하며 이경우 이름을 '미정'이라고
-- 출력한다. (14행)       
--이름               부서번호 부서이름          
---------- ---------- --------------
--SCOTT             20 RESEARCH
--SMITH              20 RESEARCH      
--ALLEN              30 SALES         
--WARD               30 SALES         
      
SELECT NVL(E.ENAME,'미정') AS "이름", NVL(TO_CHAR(E.DEPTNO),'미정') AS "부서번호", D.DNAME AS "부서이름"
FROM EMP E, DEPT D
WHERE E.DEPTNO(+) = D.DEPTNO;

-- 9. 사원들의 이름, 부서번호, 부서이름을 출력하시오. 
-- 단, 아직 부서 배치를 못받은 직원도  출력하며 이경우 부서번호는  0 으로
-- 출력한다.        
--이름               부서번호     부서이름          
---------- ---------- --------------
--MILLER		10	ACCOUNTING
--KING		10	ACCOUNTING
--CLARK		10	ACCOUNTING
--FORD		20	RESEARCH
--JONES		20	RESEARCH
--SMITH		20	RESEARCH
--SCOTT		20	RESEARCH
--JAMES		30	SALES
--TURNER	30	SALES
--BLAKE		30	SALES
--MARTIN	30	SALES
--WARD		30	SALES
--ALLEN		30	SALES
--ADAMS		0	(null)     

SELECT E.ENAME AS "이름", NVL(E.DEPTNO,0) AS "부서번호", D.DNAME AS "부서이름"
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO(+);

--10. 커미션이 정해진 모든 직원의 이름, 커미션, 부서이름, 위치를 조회하는 sql을 작성하시오.

--ENAME           COMM        DNAME         	LOC
----------------------------------------------------
--TURNER	0	SALES		CHICAGO
--MARTIN	1400	SALES		CHICAGO
--WARD		500	SALES		CHICAGO
--ALLEN		300	SALES		CHICAGO         

SELECT E.ENAME, E.COMM, D.DNAME, D.LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
AND E.COMM IS NOT NULL;

-- 11. DALLAS에서 근무하는 사원의 이름,  월급, 등급을 출력하시오.
--이름         월급             등급          
---------- --------- --------------
--SMITH      800            1      
--JONES      2975          4   
--SCOTT	     3000	        4
--FORD       3000          4      

SELECT E.ENAME AS "이름", E.SAL AS "월급", S.GRADE AS "등급"
FROM EMP E, SALGRADE S, DEPT D
WHERE E.DEPTNO = D.DEPTNO
AND E.SAL BETWEEN S.LOSAL AND S.HISAL
AND D.LOC = 'DALLAS';

-- 12. 사원들의 이름, 부서번호, 부서이름을 출력하시오. 
-- 단, 직원이 없는 부서도 출력하며 이경우 직원 이름을 '누구?'라고
-- 출력한다. 아직 부서 배치를 못받은 직원도  출력하며 부서 번호와 부서 이름을
-- '어디?' 이라고 출력한다.     
--이름               부서번호 부서이름          
---------- ---------- --------------
--ADAMS	어디?	어디?
--ALLEN	30	SALES
--BLAKE	30	SALES
--CLARK	10	ACCOUNTING
--FORD	20	RESEARCH
--JAMES	30	SALES
--JONES	20	RESEARCH
--KING	10	ACCOUNTING
--MARTIN	30	SALES
--MILLER	10	ACCOUNTING
--SCOTT	20	RESEARCH
--SMITH	20	RESEARCH
--TURNER	30	SALES
--WARD	30	SALES
--누구?	40	OPERATIONS  

SELECT E.ENAME AS "이름", NVL(TO_CHAR(E.DEPTNO),'어디?') AS "부서번호", NVL(D.DNAME,'어디?') AS "부서이름"
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO(+);

--13. 사원번호와 사원이름, 그리고 그 사원을 관리하는 관리자의 
--   사원번호와 사원이름을 출력하되 각각의 컬럼명을 '사원번호',
--   '사원이름', '관리자번호', '관리자이름'으로 하여 출력하시오. 
      관리자가 없으면 '없음'을 대신 출력한다.
--    사원번호 사원이름            관리자번호 관리자이름     
---------- ---------- ---------- ----------
--7876	ADAMS	7788	SCOTT
--7902	FORD	7566	JONES
--7788	SCOTT	7566	JONES
--7900	JAMES	7698	BLAKE
--7844	TURNER	7698	BLAKE
--7654	MARTIN	7698	BLAKE
--7521	WARD	7698	BLAKE
--7499	ALLEN	7698	BLAKE
--7934	MILLER	7782	CLARK
--7782	CLARK	7839	KING
--7698	BLAKE	7839	KING
--7566	JONES	7839	KING
--7369	SMITH	7902	FORD
--7839	KING	없음	없음

SELECT E.EMPNO AS "사원번호", E.ENAME AS "사원이름", NVL(TO_CHAR(M.EMPNO),'없음') AS "관리자번호", NVL(M.ENAME, '없음') AS "관리자이름"
FROM EMP E, EMP M
WHERE E.MGR = M.EMPNO(+);