--�������ϸ� : exercise3.sql
-- scott_create_table.sql �� �����Ͽ� scott ���� �������� �����Ű�� 
-- course1 �� couse2 ���̺��� ������ �Ŀ� �����Ѵ�.

-- 1. ���տ����� �ǽ� 

-- 1.1 course1 �� course2 �� ��� �����ϴ� �л����� �̸�, ��ȭ ��ȣ �׸��� 
--    ���̸� ����Ͻÿ�.
select * from course1
intersect
select * from course2;
  
-- 1.2 course1 �̵� course2 �� �����ϴ� �л����� �̸�, ��ȭ ��ȣ �׸��� 
--    ���̸� ����ϴµ� ���̰� ���� ������ ����Ͻÿ�.
select  name, phone, age from course1
union 
select name, phone, age from course2 order by age;

-- 1.3 course1�� ���������� course2 �� �������� �ʴ� �л����� �̸��� ����Ͻÿ�.
select * from course1
minus
select * from course2;
  
-- 1.4 course2�� ���������� course1 �� �������� �ʴ� �л����� �̸��� ��ȭ��ȣ�� 
--    �̸� ������ ����Ͻÿ�.

select * from course2
minus
select * from course1 order by 1;
  
  
--2. ��� ������ ������ ����� ���Ͻÿ�. 
--       (�Ҽ��� ���� ��°�ڸ������� ��Ÿ���� ��°�ڸ� ���ʹ� �����Ͻÿ�)


--	���� ���
 --              -----------
--	   x

select trunc(avg(sal),2) as ������� from emp;

--3. ��� �������� �޴� Ŀ�̼��� ���� ���Ͻÿ�.
--	Ŀ�̼� ��
               -----------
--	  x

select sum(comm) as Ŀ�̼��� from emp;


--4. �� ���޺��� �ѿ����� ����ϵ� �ѿ����� ���� ������ ����Ͻÿ�.

--	���޸�	�ѿ���
--	----------------------------
--	xxxx          xxx
--	 :	   :
--
select JOB as "���޸�" , SUM(SAL) as "�ѿ���" from emp
GROUP BY JOB
ORDER BY �ѿ���;

--5. �� �μ����� �ٹ��ϴ� �������� ����� �˰�ʹ�. ���� �������� ����ϴ� SQL
--    �� �ۼ��Ͻÿ� .

--	�μ�����	   �������
--	----------------------------
--	����          1��
--	30�� �μ�   6��
--	20�� �μ�   4��
--	10�� �μ�   3��

SELECT CASE DEPTNO
    WHEN 10 THEN '10�� �μ�'
    WHEN 20 THEN '20�� �μ�'
    WHEN 30 THEN '30�� �μ�'
    ELSE '����'
END AS "�μ�����", COUNT(ENAME) as "�������" FROM EMP
GROUP BY DEPTNO;


--6. �⵵���� ����� �Ի��ߴ��� �˰�ʹ�. ���� �������� ����ϴ� SQL
--    �� �ۼ��Ͻÿ� . (���� �Ի��� ������ ���)

--	�Ի�⵵ 	   �Ի� �ο���
--	----------------------------
--	1981��	   10��
--	1987��	   2��
--	1982��	   1��
--	1980��	   1��

select to_char(hiredate, 'yyyy"��"') as �Ի�⵵, count(*) as �Ի��ο��� from emp 
group by to_char(hiredate, 'yyyy"��"')
order by to_char(hiredate, 'yyyy"��"') desc;

--7. ��ü �������� ���ڸ� �μ������� ���� �������� ����ϴ� SQL
--    �� �ۼ��Ͻÿ� .

--	2019�� 12�� 27�� �������� 14���� �ٹ����Դϴ�.

select to_char(sysdate, 'yyyy"��" mm"��" dd"�� ��������"') || count(ename) || '���� �ٹ����Դϴ�' as result from emp;

--8. ���޺� �ѿ����� ����ϵ�, ������ 'MANAGER'�� �������� �����Ͻÿ�. 
--   �׸��� �� �ѿ����� 5000���� ū ���޿� �ѿ��޸� ����Ͻÿ�.

--	���޸�	�ѿ���
--	----------------------------
--	xxxx          xxx
--	 :	   :
select job as ���޸�, sum(sal) as �ѿ��� from emp 
where job != 'MANAGER'
group by job HAVING sum(sal) >5000;

--9. 30�� �μ��� ������ ����� ����� �˻��Ѵ�.
-- ��������� ����+Ŀ�̼�(null�̸� 0���� ���)�̸� 
-- ��� ����� �Ҽ��� ���� �� �ڸ�(�ݿø�)���� ���ϵ� ������� ����Ѵ�.
 --             ������       ��տ���
 --             ---------------------------
--              xxxx         xxx.xx
--	 :	    :
--select job , sal, comm, nvl2(comm, sal + comm, sal) from emp where deptno = '30';

SELECT DEPTNO AS "������", ROUND(AVG(SAL+NVL(COMM,0)),2) FROM EMP
GROUP BY DEPTNO
HAVING DEPTNO = 30;

--select job as ������, to_char(avg(nvl2(comm, sal + comm, sal)), '999,999.00')  as ��տ��� from emp 
--where deptno = '30' 
--group by job;
--10. ���� �Ի��ο��� ���� �������� ����ϴ� SQL �� �ۼ��Ͻÿ� . 
--     �Ի������ ���������̸� �Ի��ο��� 2�� �̻��� ��쿡�� ����Ѵ�.


--	02��	2��
--	04��	2��
--	05��	2��
--	09��	2��
--	12��	3��

select to_char(hiredate, 'mm"��"')as �Ի��, count(ENAME) || '��' as �Ի��ο� from emp 
group by to_char(hiredate, 'mm"��"')
HAVING COUNT(ENAME)>=2
order by �Ի��;



  