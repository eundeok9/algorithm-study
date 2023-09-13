-- 코드를 입력하세요
SELECT DATETIME as '시간'
FROM ANIMAL_INS
WHERE DATETIME = (select min(datetime) from animal_ins);