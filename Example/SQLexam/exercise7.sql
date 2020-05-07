-- ��� �ǽ������� EMP�� DEPT ���̺��� ������ ������ ���� ����� �����ϰ�
-- ����� ���� Ȯ���� ���� ROLLBACK ����� �����Ѵ�.

-- [ �׽�Ʈ ���� : ��!! ]
-- ������ Ȯ��
-- �������� �䱸�Ǵ� DML �� ����
-- ������ Ȯ��
-- rollback

-- 1. EMP ���̺��� ������ȣ�� 7499���� ������ ������ 5000�޷��� �����Ѵ�.

UPDATE EMP
    SET SAL = 5000
WHERE EMPNO = 7499;

SELECT * FROM EMP;

ROLLBACK;

-- 2. EMP���̺��� �μ���ȣ�� 20���� �������� ������ ���� ���޿��� 10% �λ��� �ݾ����� �����Ѵ�.

UPDATE EMP
    SET SAL = SAL*1.1
WHERE DEPTNO = 20;

SELECT * FROM EMP;

ROLLBACK;

-- 3. DEPT ���̺� �Ʒ��� �������� �����͸� �Է��Ѵ�.
-- �μ���ȣ: 50, �μ���ġ: BOSTON,  �μ���: RESERCH

INSERT INTO DEPT
    VALUES ( 50, 'RESERCH', 'BOSTON');

SELECT * FROM DEPT;

ROLLBACK;

-- 4. EMP ���̺� �Ʒ��� ���� �����͸� �����Ѵ�.
-- ������ȣ: 9900, �����̸�: JACKSON, ����: SALESMAN, �μ���ȣ: 10, ���� : 800

INSERT INTO EMP
    VALUES (9900, 'JACKSON', 'SALESMAN', NULL, NULL, 800, NULL, 10);
    
SELECT * FROM EMP;

ROLLBACK;

-- 5. DEPT ���̺� �Ʒ��� �������� �����͸� �Է��Ѵ�.
-- �μ���ȣ: 60, �μ���ġ: NULL,  �μ���: MARKETING

INSERT INTO DEPT
    VALUES(60, 'MARKETING', NULL);
    
SELECT * FROM DEPT;

ROLLBACK;

-- 6. ������ȣ�� 7698���� ������ �μ���ȣ�� 7369�� ������ 
-- �μ���ȣ�� �����Ѵ�.

UPDATE EMP
    SET DEPTNO = (SELECT DEPTNO FROM EMP WHERE EMPNO=7369)
WHERE EMPNO = 7698;

SELECT * FROM EMP;

ROLLBACK;

-- 7. 20�� �μ��� �������� ��� �����Ѵ�.

DELETE FROM EMP
WHERE DEPTNO = 20;

SELECT * FROM EMP;

ROLLBACK;

-- 8. ������ 1000 ������ �������� �����Ѵ�.

DELETE FROM EMP
WHERE SAL <= 1000;

SELECT * FROM EMP;

ROLLBACK;

-- 9. ������ȣ�� 7900 �� ������ ������ ���� ���޿��� 5% ������Ű�� �μ���ȣ�� 40���� �����Ѵ�.

UPDATE EMP
    SET SAL = SAL * 1.05,
        DEPTNO = 40
WHERE EMPNO = 7900;

SELECT * FROM EMP;

ROLLBACK;

-- 10. ���縦 �������� �Ի����� 38�� �̻��� �����鿡 ���Ͽ�  ������ 2��� �����ϰ� Ŀ�̼ǵ� 3000���� �����Ѵ�.
       --  (�Ի����� �⵵�� �������� �ݿø��Ͽ� ����Ѵ�.)
       
UPDATE EMP
    SET SAL = SAL*2,
        COMM = 3000
WHERE (TO_CHAR(SYSDATE,'YYYY')-TO_CHAR(ROUND(HIREDATE,'YYYY'),'YYYY')) >= 38;

SELECT * FROM EMP;

ROLLBACK;