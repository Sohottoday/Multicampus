CREATE TABLE DEPT_TEMP
AS SELECT * FROM DEPT;

INSERT INTO DEPT_TEMP ( DEPTNO, DNAME, LOC)
            VALUES(50, 'DATABASE', 'SEOUL');
            
INSERT INTO DEPT_TEMP
    VALUES(60, 'NETWORK', 'BUSAN');
    
INSERT INTO DEPT_TEMP(DEPTNO, DNAME, LOC)
    VALUES (70, 'WEB', NULL);
    
INSERT INTO DEPT_TEMP(DEPTNO, DNAME, LOC)
    VALUES( 80, 'MOBILE',  ' ');
    
INSERT INTO DEPT_TEMP ( DEPTNO, LOC)
    VALUES ( 90, 'INCHEON');
    
SELECT * FROM DEPT_TEMP;
    
CREATE TABLE EMP_TEMP
    AS SELECT * FROM EMP
    WHERE 1<> 1;    -- 모두 거짓. 이 식 결과 비어있는 테이블, 비어있는 RESULTSET
    
SELECT * FROM EMP;

SELECT * FROM TAB;
    

DESC EMP;