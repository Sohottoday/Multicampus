

--�������ϸ� : exercise2.sql
--QUESTION
--1. ��� ���̺��� ����̸��� ù���ڴ� �빮�ڷ�, �������� �ҹ��ڷ� ����Ͻÿ�.
-- [���]       ����̸�
--           ---------------------
--                  Smith
		
select INITCAP(ENAME) AS "����̸�" FROM EMP;

--2. ������̺��� ����̸��� ��� �̸��� �ι�° ���ں��� �׹�° ���ڱ���
-- ����Ͻÿ�.
-- [���]         ����̸�    2-4����
--                  ---------------------
--                  SMITH        MIT
SELECT ENAME AS "����̸�", SUBSTR(ENAME, 2, 3) AS "2~4����" FROM EMP;		

--3. ������̺��� ��� �̸��� ���� ������ ����Ͻÿ�.
SELECT LENGTH(ENAME) AS "�̸� ���� ����" FROM EMP;

--4. ������̺��� ��� �̸��� �� ���� �ϳ��� ������ ���� �ϳ��� ����ϵ� 
-- ��� �ҹ��ڷ� ���� ����Ͻÿ�.
SELECT LOWER(SUBSTR(ENAME,1,1)) || LOWER(SUBSTR(ENAME,LENGTH(ENAME),1)) FROM EMP;

--5. 3456.78�� �ݿø��Ͽ� �Ҽ��� �Ʒ� ù��° �ڸ� ������ ��Ÿ���ÿ�.
SELECT ROUND(3456.78 , 1) AS "�Ҽ��� �Ʒ� ù��°" FROM DUAL;

--6. ���޿� 50�� ���ϰ� �ʴ����� �����Ͽ� ����ϴµ� ���޵ڿ� '��'�� ���̰� 
--    õ�������� ','�� �ٿ��� ����Ѵ�.
--[���]	��� ���
-----------------
--          40,000��
--	80,000��
-- 	62,500��
--	148,700��

SELECT TO_CHAR(TRUNC(SAL*50,-2),'999,999,999') AS "��� ���" FROM EMP;

--7. ���� �̸��� Ŀ�̼� ���� ���θ� ����ϴµ� �����Ǿ����� '����'
--    �������� �ʾ����� '����'�� ����Ͻÿ�.
--    	SMITH	����	
--	ALLEN	����	300
--	WARD	����	200
--	JONES	����	30
	
SELECT ENAME, NVL2(TO_CHAR(COMM), '����', '����') AS "���� ����", COMM FROM EMP;

--8. ���� �̸��� �μ���ȣ �׸��� �μ���ȣ�� ���� �μ����� ����Ͻÿ�.
--    �μ��� ���� ������ '����' �� ����Ͻÿ�.
--    (�μ��� : 10 �̸� 'A �μ�', 20 �̸� 'B �μ�', 30 �̸� 'C �μ�')
	
SELECT CASE DEPTNO
WHEN 10 THEN 'A �μ�'
WHEN 20 THEN 'B �μ�'
WHEN 30 THEN 'C �μ�'
ELSE '����'
END AS "�μ���" FROM EMP;

--9. ������ 'SALESMAN'�̰� ������ 1000�̻��� �����
-- �̸��� ������ ����Ͻÿ�.

SELECT ENAME, SAL FROM EMP
WHERE SAL>=1000
AND JOB='SALESMAN';

--10. ���ó�¥�� ���ó�¥���� 10���� ���� ��¥�� ����Ͻÿ�.

SELECT SYSDATE AS "���� ��¥", SYSDATE+10 AS "10�� ���� ��¥" FROM DUAL;

--11. ���� �ð��� "....�� ..�� ..�� ..�� ..��" ���� ����Ͻÿ�.

SELECT TO_CHAR(SYSDATE, 'YYYY"��" MM"��" DD"��" HH24"��" MI"��"') AS "���糯¥�ð�" FROM DUAL;

--12. ������ �̸�, ���޿�, ������ ��ȸ�ϴ� ���Ǹ� �ۼ��Ͻÿ�.
--(��, ������ ������ $200�� �� ���ʽ��� �����Ͽ� ����մϴ�.)

--�̸�              ���޿�               ����
---------------------------------------------------
--SMITH             800                 12000
--ALLEN            1600                 21600
--WARD             1250                 17400

SELECT ENAME AS "�̸�", SAL AS "�޿�", (SAL+200)*12 AS "����" FROM EMP;

--13.  12��27��_�߰�.docx �� ��ü

SELECT ENAME AS "�̸�", SAL AS "����",
CASE
    WHEN SAL < 1000 THEN 'A'
    WHEN SAL BETWEEN 1000 AND 2000 THEN 'B'
    WHEN SAL BETWEEN 2000 AND 3000 THEN 'C'
    WHEN SAL BETWEEN 3000 AND 4000 THEN 'D'
    ELSE 'E'
END AS "�ڵ�" FROM EMP;

--14. 12��27��_�߰�.docx �� ��ü

SELECT ENAME AS "�̸�", JOB AS "�μ���ȣ",
    DECODE(DEPTNO, 10,'A',
                   20,'B',
                   30,'C',
                   40,'E',
                   'F') AS "�ڵ�"
FROM EMP;
                   

--15. �̸��� �ι�° ���ڰ� ��A���� ��� ������ �̸��� ��ȸ�ϴ� ���Ǹ� �ۼ��Ͻÿ� 

--ENAME
----------
--WARD 
--MARTIN
--JAMES

SELECT ENAME FROM EMP
WHERE INSTR(ENAME, 'A')=2;


--16.   ��� ������ �̸��� ��������� �Ի�Ⱓ�� ������(���� ����� ���� �ݿø��� ��)�� 
--   ��ȸ�ϴ� ���Ǹ� �ۼ��Ͻÿ�
--   (�̶�, �Ի�Ⱓ�� �ش��ϴ� ����Ī�� ��MONTHS WORKED���� �ϰ�, 
--    �Ի�Ⱓ�� ���� ���� ���������� �����Ѵ�.)

--��¿�)
--ENAME         MONTHS WORKED
--------------------------------
--ADAMS            284
--SCOTT            286
--MILLER           348
     
SELECT ENAME, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE),0) AS "MONTHS WORKED" FROM EMP
ORDER BY "MONTHS WORKED" ASC;

--17. ������̺��� ����̸��� ������� ���� ��¥������ �ٹ��ϼ��� ���Ͻÿ�.
--����̸�   �ٹ��ϼ�
-- -----------------------
--SMITH    12474��
--ALLEN    12409��
--WARD    12407��
--JONES    12368��
--MARTIN    12189��
--BLAKE    12369��
      
SELECT ENAME AS "����̸�", TRUNC(SYSDATE-HIREDATE,0)||'��' AS "�ٹ��ϼ�" FROM EMP;

--18. 1981�⵵�� �Ի��� �������� �̸�, ���� �׸��� �Ի�����
--         �Ի��� ������ ����Ͻÿ�.

SELECT ENAME, JOB, HIREDATE FROM EMP
WHERE HIREDATE LIKE '81%'
ORDER BY HIREDATE ASC;

--19. �������� �������� ������ ����ϴ� SQL  ����� �ۼ��Ͻÿ�.

SELECT NEXT_DAY('19/11/14','������') AS "������ �̰� �³�?" FROM DUAL;

--20. ���縦 �������� ���� �¾�� �� ���� �Ǿ����� �� �� �ִ� 
--      SQL ����� �ۼ��Ͻÿ�.

SELECT TRUNC(MONTHS_BETWEEN(SYSDATE, '91/11/14'),0) AS "����ϱ�?" FROM DUAL;

--21. �������� �̸��� ���� �׸��� Ŀ�̼� ������ ����ϴµ�
--     Ŀ�̼��� �������� ���� ������ "����"�̶�� ����Ͻÿ�.

SELECT ENAME, SAL, NVL(TO_CHAR(COMM),'����') AS "����" FROM EMP;

--22. ������̺��� �̸��� ù���ڰ� A�̰� ������ ���ڰ� N�� �ƴ� �����
-- �̸��� ����Ͻÿ�.

SELECT ENAME FROM EMP
WHERE SUBSTR(ENAME,1,1)='A'
AND SUBSTR(ENAME,LENGTH(ENAME),1) != 'N';

--23. ������ �̸�, �Ի� ��¥ �׸��� �⵵�� ���������� �ݿø� ��¥��
--     ����Ͻÿ�.        

SELECT ENAME, HIREDATE, ROUND(HIREDATE, 'YYYY') AS "�ѱ۸��˾Ƹ���" FROM EMP;
