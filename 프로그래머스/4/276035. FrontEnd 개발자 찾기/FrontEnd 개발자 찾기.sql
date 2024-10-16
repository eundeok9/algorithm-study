-- 코드를 작성해주세요
select distinct id, email, first_name, last_name
from skillcodes as a, developers as b
where a.category like 'Front End' and (b.skill_code & a.code) = a.code
order by id;