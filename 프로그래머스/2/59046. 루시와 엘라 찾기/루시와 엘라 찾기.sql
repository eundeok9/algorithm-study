-- 코드를 입력하세요
SELECT animal_id, name, SEX_UPON_INTAKE
from ANIMAL_INS
where name in ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')
order by animal_id;