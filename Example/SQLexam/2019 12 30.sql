select * from emp;
select * from dept;

select* from emp, dept;

select * from emp, dept
where emp.deptno = dept.deptno;

select * from emp, dept
where emp.deptno = dept.deptno(+); --(+)란 조인하는 동안 null 행 하나를 추가하라는 뜻, left outer

select * from emp, dept
where emp.deptno(+) = dept.deptno; -- right outer

select * from emp, dept  where emp.deptno = dept.deptno(+)
union
select * from emp, dept where emp.deptno(+) = dept.deptno;

select * from salgrade;

select * from emp, salgrade 
where emp.sal between salgrade.losal and salgrade.hisal;

SELECT E1.EMPNO, E1.ENAME, E1.MGR, E2.EMPNO AS MGR_EMPNO, E2.ENAME AS MGR_ENAME FROM EMP E1, EMP E2
WHERE E1.MGR = E2.EMPNO;

SELECT E.ENAME, NVL(M.ENAME, '없음')
FROM EMP E, EMP M
WHERE E.MGR = M.EMPNO(+);


