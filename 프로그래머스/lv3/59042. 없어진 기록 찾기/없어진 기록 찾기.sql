-- 코드를 입력하세요
select animal_id, name
from animal_outs
where animal_outs.animal_id not in (select animal_id from animal_ins)