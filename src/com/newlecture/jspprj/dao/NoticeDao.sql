--�Խñ� ��� ��ȸ
SELECT * FROM NOTICES ORDER BY REGDATE DESC;

--�Խñ� ��ȸ


--���� �������׿��� ���� ū CODE ���� �����ÿ�
SELECT NVL(MAX(TO_NUMBER(CODE)),0)+1 FROM NOTICES;
SELECT ISNULL(MAX(CAST(CODE AS INT)),0)+1 FROM NoticeFiles;
SELECT MAX(CAST(CODE AS INT))+1 FROM NoticeFiles;



--20���� ���� ���ڵ带 ������ ������ �ۼ��Ͻÿ�.
--1 ������, 2 ������
--2 ������ ����� ��ȸ�� ������ ���Ŀ� ������ �ִ� �� ����.
SELECT * FROM (SELECT ROWNUM NUM, NOTICES.* FROM NOTICES ORDER BY REGDATE DESC)
WHERE NUM BETWEEN 3 AND 4


SELECT * FROM 
(SELECT ROWNUM NUM, N.* FROM 
	(SELECT * FROM NOTICES NOTICES ORDER BY REGDATE DESC) N
)
WHERE NUM BETWEEN 3 AND 4


SELECT N.* FROM
(
	SELECT (ROW_NUMBER() OVER (ORDER BY REGDATE DESC)) NUM, Notices.* 
	FROM NOTICES
) N
WHERE N.NUM BETWEEN 11 AND 20;

SELECT MAX(CAST(CODE AS VARCHAR(10)))+1 CODE FROM NOTICES;

SELECT TOP 1 * FROM NOTICES 
WHERE REGDATE > (SELECT REGDATE FROM NOTICES WHERE CODE='242')
ORDER BY REGDATE ASC;

SELECT * FROM NOTICES ORDER BY REGDATE DESC;

SELECT TOP 1 * FROM NOTICES 
WHERE REGDATE < (SELECT REGDATE FROM NOTICES WHERE CODE='242')
ORDER BY REGDATE DESC;


SELECT MID USERID, PWD PASSWORD, 1 ENABLED FROM MEMBERS WHERE MID=?

SELECT MID USERID, 'ROLE_USER' AUTHORITIES FROM MEMBERS WHERE MID=?-- INNER JOIN ROLES






