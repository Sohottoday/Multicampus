

--제출파일명 : exercise2.sql
--QUESTION
--1. 사원 테이블에서 사원이름을 첫글자는 대문자로, 나머지는 소문자로 출력하시오.
-- [결과]       사원이름
--           ---------------------
--                  Smith
		
select INITCAP(ENAME) AS "사원이름" FROM EMP;

--2. 사원테이블에서 사원이름과 사원 이름의 두번째 글자부터 네번째 글자까지
-- 출력하시오.
-- [결과]         사원이름    2-4문자
--                  ---------------------
--                  SMITH        MIT
SELECT ENAME AS "사원이름", SUBSTR(ENAME, 2, 3) AS "2~4문자" FROM EMP;		

--3. 사원테이블의 사원 이름의 문자 개수를 출력하시오.
SELECT LENGTH(ENAME) AS "이름 문자 개수" FROM EMP;

--4. 사원테이블에서 사원 이름의 앞 글자 하나와 마지막 글자 하나만 출력하되 
-- 모두 소문자로 각각 출력하시오.
SELECT LOWER(SUBSTR(ENAME,1,1)) || LOWER(SUBSTR(ENAME,LENGTH(ENAME),1)) FROM EMP;

--5. 3456.78을 반올림하여 소수점 아래 첫번째 자리 까지만 나타내시오.
SELECT ROUND(3456.78 , 1) AS "소수점 아래 첫번째" FROM DUAL;

--6. 월급에 50를 곱하고 십단위는 절삭하여 출력하는데 월급뒤에 '원'을 붙이고 
--    천단위마다 ','를 붙여서 출력한다.
--[결과]	계산 결과
-----------------
--          40,000원
--	80,000원
-- 	62,500원
--	148,700원

SELECT TO_CHAR(TRUNC(SAL*50,-2),'999,999,999') AS "계산 결과" FROM EMP;

--7. 직원 이름과 커미션 설정 여부를 출력하는데 설정되었으면 '설정'
--    설정되지 않았으면 '미정'을 출력하시오.
--    	SMITH	미정	
--	ALLEN	설정	300
--	WARD	설정	200
--	JONES	설정	30
	
SELECT ENAME, NVL2(TO_CHAR(COMM), '설정', '미정') AS "설정 여부", COMM FROM EMP;

--8. 직원 이름과 부서번호 그리고 부서번호에 따른 부서명을 출력하시오.
--    부서가 없는 직원은 '없당' 을 출력하시오.
--    (부서명 : 10 이면 'A 부서', 20 이면 'B 부서', 30 이면 'C 부서')
	
SELECT CASE DEPTNO
WHEN 10 THEN 'A 부서'
WHEN 20 THEN 'B 부서'
WHEN 30 THEN 'C 부서'
ELSE '없당'
END AS "부서명" FROM EMP;

--9. 직위가 'SALESMAN'이고 월급이 1000이상인 사원의
-- 이름과 월급을 출력하시오.

SELECT ENAME, SAL FROM EMP
WHERE SAL>=1000
AND JOB='SALESMAN';

--10. 오늘날짜와 오늘날짜에서 10일을 더한 날짜를 출력하시오.

SELECT SYSDATE AS "오늘 날짜", SYSDATE+10 AS "10일 더한 날짜" FROM DUAL;

--11. 현재 시간을 "....년 ..월 ..일 ..시 ..분" 으로 출력하시오.

SELECT TO_CHAR(SYSDATE, 'YYYY"년" MM"월" DD"일" HH24"시" MI"분"') AS "현재날짜시간" FROM DUAL;

--12. 직원의 이름, 월급여, 연봉을 조회하는 질의를 작성하시오.
--(단, 직원의 연봉은 $200의 월 보너스를 포함하여 계산합니다.)

--이름              월급여               연봉
---------------------------------------------------
--SMITH             800                 12000
--ALLEN            1600                 21600
--WARD             1250                 17400

SELECT ENAME AS "이름", SAL AS "급여", (SAL+200)*12 AS "연봉" FROM EMP;

--13.  12월27일_추가.docx 로 대체

SELECT ENAME AS "이름", SAL AS "월급",
CASE
    WHEN SAL < 1000 THEN 'A'
    WHEN SAL BETWEEN 1000 AND 2000 THEN 'B'
    WHEN SAL BETWEEN 2000 AND 3000 THEN 'C'
    WHEN SAL BETWEEN 3000 AND 4000 THEN 'D'
    ELSE 'E'
END AS "코드" FROM EMP;

--14. 12월27일_추가.docx 로 대체

SELECT ENAME AS "이름", JOB AS "부서번호",
    DECODE(DEPTNO, 10,'A',
                   20,'B',
                   30,'C',
                   40,'E',
                   'F') AS "코드"
FROM EMP;
                   

--15. 이름의 두번째 문자가 “A”인 모든 직원의 이름을 조회하는 질의를 작성하시오 

--ENAME
----------
--WARD 
--MARTIN
--JAMES

SELECT ENAME FROM EMP
WHERE INSTR(ENAME, 'A')=2;


--16.   모든 직원의 이름과 현재까지의 입사기간을 월단위(가장 가까운 월로 반올림할 것)로 
--   조회하는 질의를 작성하시오
--   (이때, 입사기간에 해당하는 열별칭은 “MONTHS WORKED”로 하고, 
--    입사기간이 가장 적은 직원순으로 정렬한다.)

--출력예)
--ENAME         MONTHS WORKED
--------------------------------
--ADAMS            284
--SCOTT            286
--MILLER           348
     
SELECT ENAME, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE),0) AS "MONTHS WORKED" FROM EMP
ORDER BY "MONTHS WORKED" ASC;

--17. 사원테이블에서 사원이름과 사원들의 오늘 날짜까지의 근무일수를 구하시오.
--사원이름   근무일수
-- -----------------------
--SMITH    12474일
--ALLEN    12409일
--WARD    12407일
--JONES    12368일
--MARTIN    12189일
--BLAKE    12369일
      
SELECT ENAME AS "사원이름", TRUNC(SYSDATE-HIREDATE,0)||'일' AS "근무일수" FROM EMP;

--18. 1981년도에 입사한 직원들의 이름, 직위 그리고 입사일을
--         입사한 순으로 출력하시오.

SELECT ENAME, JOB, HIREDATE FROM EMP
WHERE HIREDATE LIKE '81%'
ORDER BY HIREDATE ASC;

--19. 내생일을 기준으로 요일을 출력하는 SQL  명령을 작성하시오.

SELECT NEXT_DAY('19/11/14','월요일') AS "문제가 이게 맞나?" FROM DUAL;

--20. 현재를 기준으로 내가 태어난지 몇 개월 되었는지 알 수 있는 
--      SQL 명령을 작성하시오.

SELECT TRUNC(MONTHS_BETWEEN(SYSDATE, '91/11/14'),0) AS "몇개월일까?" FROM DUAL;

--21. 직원들의 이름과 월급 그리고 커미션 정보를 출력하는데
--     커미션이 정해지지 않은 직원은 "미정"이라고 출력하시오.

SELECT ENAME, SAL, NVL(TO_CHAR(COMM),'미정') AS "정보" FROM EMP;

--22. 사원테이블에서 이름의 첫글자가 A이고 마지막 글자가 N이 아닌 사원의
-- 이름을 출력하시오.

SELECT ENAME FROM EMP
WHERE SUBSTR(ENAME,1,1)='A'
AND SUBSTR(ENAME,LENGTH(ENAME),1) != 'N';

--23. 직원의 이름, 입사 날짜 그리고 년도를 기준으로한 반올림 날짜를
--     출력하시오.        

SELECT ENAME, HIREDATE, ROUND(HIREDATE, 'YYYY') AS "한글못알아먹음" FROM EMP;
