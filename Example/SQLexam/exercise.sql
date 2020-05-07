-- ������ ������ �������� �ذ��Ͽ� �����Ѵ�.
-- �������ϸ� : exercise1.sql

--1. ��� ���̺��� ����Ʈ�� ����Ͻÿ�.
select * from tab;

--2. emp ���̺�� dept ���̺��� ������ ����Ͻÿ�.
desc emp;
desc dept;
--3. ���(emp)���̺��� ��� �����͸� ����Ͻÿ�.
select * from emp;
--4. ������̺��� �����ȣ, ����̸�, ������ ����Ͻÿ�.
select empno, ename, sal from emp;
--5. ������̺��� ���޿��� �̴µ� �ߺ��� �����Ͱ� ���� ����Ͻÿ�.
select distinct sal from emp;
--6. ������̺��� ����̸��� ������ ����ϴµ� ������ �÷�����
-- "�� ��","�� ��"���� �ٲ㼭 ����Ͻÿ�. ��, ALIAS�� ���� �߰�
SELECT ENAME AS "�� ��", SAL AS "�� ��" FROM EMP; 
--7. ������̺��� ����̸�, ������ �̰�, ���ް� Ŀ�̼���  ���� ����
-- ����ϴµ� �÷����� '�Ǳ޿�'�̶�� �ؼ� ����Ͻÿ�.
-- ��, NULL���� ��Ÿ���� �ʰ� �Ͻÿ�.(Ŀ�̼� �ȹ޴»������)
select ename, sal, sal+comm as "�Ǳ޿�" from emp
WHERE COMM IS NOT NULL;
--8. ������̺��� 'FORD'�̶�� ����� �����ȣ, �̸�, ������ ����Ͻÿ�.
select empno, ename, sal from emp
where ENAME = 'FORD';
--9. ������̺��� ������ 'SALESMAN'�� ����� �����ȣ, �̸�, ������
-- ����Ͻÿ�.
select empno, ename, JOB from emp
where job = 'SALESMAN';
--10. ������̺��� �����ȣ�� 7499, 7521, 7654�� ����� �����ȣ, �̸�
-- ������ ����Ͻÿ�.
SELECT EMPNO, ENAME, SAL FROM EMP
WHERE EMPNO IN('7499','7521','7654');
--11. ������̺��� ������ 1500���� 3000������ ����� �����ȣ, �̸�,
-- ������ ����Ͻÿ�.
SELECT EMPNO, ENAME, SAL FROM EMP
WHERE SAL BETWEEN 1500 AND 3000;
--12. ��� ���̺��� �Ŵ����� ���� ������ �̸��� ����Ͻÿ�.
SELECT ENAME FROM EMP
WHERE MGR IS NULL;
--13. ������̺��� ������ ���� ������ ��� ������ ����Ͻÿ�.
SELECT * FROM EMP
ORDER BY SAL DESC;
--14. ������̺��� ������ �̸��� �Ի����� ����ϴµ� �ֱٿ� �Ի��� ������ ����Ͻÿ�.
SELECT ENAME, HIREDATE FROM EMP
ORDER BY HIREDATE DESC;
--15. ��� ���̺��� 30�� �μ��� �ٹ��ϴ� �������� �̸��� ����ϴµ�
-- �Ի����� ������ ������ ����Ͻÿ�.
SELECT ENAME FROM EMP
WHERE DEPTNO = 30
ORDER BY HIREDATE ASC;