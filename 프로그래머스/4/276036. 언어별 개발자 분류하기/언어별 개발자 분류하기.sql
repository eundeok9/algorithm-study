SELECT CASE
    WHEN (d.skill_code & (select sum(code) from skillcodes where category like "Front%")) and (d.skill_code & (select code from skillcodes where name = 'Python')) then 'A'
    WHEN (d.skill_code & (select code from skillcodes where name = 'C#')) then 'B'
    WHEN (d.skill_code & (select sum(code) from skillcodes where category like 'Front%')) then 'C'
    ELSE NULL
END as grade, id, email
from developers as d
group by grade, id, email
having grade is not null
order by grade, id;