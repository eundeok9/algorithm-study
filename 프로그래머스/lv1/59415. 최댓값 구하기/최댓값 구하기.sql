-- 코드를 입력하세요
SELECT DATETIME as '시간'
from ANIMAL_INS
where DATETIME = (select max(datetime) from animal_ins)