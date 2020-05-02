--1. employees ���̺��� ������ �ľ��� �� �ִ� SQL ����� �ۼ��Ͻÿ�.

DESC EMPLOYEES;

--2. departments ���̺��� ������ �ľ��� �� �ִ� SQL ����� �ۼ��Ͻÿ�.

DESC DEPARTMENTS;

--3. ���� ��¥�� ����ϴ� SQL ����� �ۼ��Ͻÿ�.
--��¥�� �ۼ� ���� : 2020�� 1�� 2�� 

SELECT TO_CHAR(SYSDATE, 'YYYY"��" FMMM"��" FMDD"��"') AS "���� ��¥" FROM DUAL;

--4. �������� �� ������� ����Ͻÿ�.

SELECT COUNT(EMPLOYEE_ID) FROM EMPLOYEES;

--5. ������ ũ���������� ���� �������� ����Ͻÿ�.

SELECT TO_CHAR(TO_DATE('2020-12-25', 'YYYY-MM-DD') , 'DAY') AS "ũ�������� ����" FROM DUAL;

--6. �μ� ��ġ�� ���� ���� ������ id(employee_id), �̸�(first_name), �ش� ������ ����ϴ�
--�Ŵ��� ID, �Ŵ����� �̸��� ��ȸ�Ͽ� ���� �������� ����Ͻÿ�. 

--��� ��� �̸� �Ŵ��� ��� �Ŵ��� �̸�
---------------------------------------------------------------------
--178 Kimberely 149 Eleni 

SELECT E.EMPLOYEE_ID AS "���", E.FIRST_NAME AS "��� �̸�", D.EMPLOYEE_ID AS "�Ŵ��� ���", D.FIRST_NAME AS "�Ŵ��� �̸�"
FROM EMPLOYEES E JOIN EMPLOYEES D ON (E.MANAGER_ID = D.EMPLOYEE_ID)
WHERE E.DEPARTMENT_ID IS NULL;


--7. �Ի�� ���� ������ �ְ�޿��� ��ȸ�Ͽ� ����Ͻÿ�. ��, ��½� �ְ�޿� ������������
--���ĵǾ� ����ϸ� �ְ�޿��� 10000 �̻��� ������ ����մϴ�. 

--�Ի��	�ְ�޿�
--------------------------
--6�� 24,000��
--1��	17,000��
--9��	17,000��
--10��	14,000��
--:
--11�� 10,500��

SELECT TO_CHAR(HIRE_DATE, 'MON') AS "�Ի��", MAX(TO_CHAR(SALARY, '999,999'))||'��' AS "�ְ�޿�"
FROM EMPLOYEES
GROUP BY TO_CHAR(HIRE_DATE, 'MON')
ORDER BY  MAX(TO_CHAR(SALARY, '999,999'))||'��' DESC;

--8. �Ի�⵵�� ���� ���� ���Ͽ� ����Ͻÿ�. ��, �޿��� 5000���� 10000 �� ���̸� ������ 
--�׸��� �������� 7�� �̻��� ��츸 ����Ͻÿ�. ���� ����� �Ի�⵵ ������ �����Ͻÿ�.
--�Ի�⵵ ���ǿ� �´� ������
-----------------------------------------------
--05	11
--06	9
--07	8

SELECT TO_CHAR(HIRE_DATE, 'YY') AS "�Ի�⵵", COUNT(EMPLOYEE_ID) AS "���ǿ� �´� ������"
FROM EMPLOYEES
WHERE SALARY BETWEEN 5000 AND 10000
GROUP BY TO_CHAR(HIRE_DATE, 'YY')
HAVING COUNT(EMPLOYEE_ID) >=7
ORDER BY TO_CHAR(HIRE_DATE, 'YY');

--9. �Ի����� 6���� ������ �̸�(first_name), �μ��̸�(department_name) �� ����-�Ի���ޡ��� ����Ͻÿ�. 
--�����̸� ������������ �����Ͽ� ��� �մϴ�.

--�̸� �μ��̸� ���ϸ޽���
--------------------------------------------------------------
--David IT ��-�Ի����
--Donald Shipping ��-�Ի����
--:
--William Accounting ��-�Ի���� 

SELECT E.FIRST_NAME AS "�̸�", D.DEPARTMENT_NAME AS "�μ��̸�", '��-�Ի����' AS "���ϸ޼���"
FROM EMPLOYEES E JOIN DEPARTMENTS D ON(E.DEPARTMENT_ID = D.DEPARTMENT_ID)
WHERE TO_CHAR(HIRE_DATE, 'MM') = 06
ORDER BY E.FIRST_NAME ASC;

--10. 'Den'�� ���� �μ����� �ٹ��ϴ� �������� �ִ����, �ּҿ��� �׸��� ������ ����� ���Ͻÿ�.
--��, ��հ��� ����Ҷ� �ʴ��������� ����Ͻÿ�.

--�ִ���� �ּҿ��� �������
---------------------------------------------------
--11000 2500 4150

SELECT MAX(SALARY) AS "�ִ����", MIN(SALARY) AS "�ּҿ���", ROUND(AVG(SALARY),-1) AS "�������"
FROM EMPLOYEES
WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID FROM EMPLOYEES WHERE FIRST_NAME = 'Den');