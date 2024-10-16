select case
    when (d.skill_code & (select sum(code) from skillcodes where category like 'Front%')) and (d.skill_code & (select code from skillcodes where name = 'Python')) then 'A'
    when (d.skill_code & (select code from skillcodes where name = 'C#')) then 'B'
    when (d.skill_code & (select sum(code) from skillcodes where category like 'Front%')) then 'C'
    else NULL
end as grade, id, email
from developers as d
group by grade, id, email
having grade is not null
order by grade, id;