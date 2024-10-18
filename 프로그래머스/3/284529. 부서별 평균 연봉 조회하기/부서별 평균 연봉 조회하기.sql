-- 코드를 작성해주세요
select d.dept_id, d.dept_name_en, round(avg(sal),0) as avg_sal
from HR_DEPARTMENT as d , HR_EMPLOYEES as e
where d.dept_id = e.dept_id
group by d.dept_id
order by avg(sal) desc;