-- 코드를 작성해주세요
select sum(c.score) as score, b.emp_no, b.emp_name, b.position, b.email
from HR_DEPARTMENT as a, HR_EMPLOYEES as b, HR_GRADE as c
where a.dept_id = b.dept_id and b.emp_no = c.emp_no and year = 2022
group by b.emp_no, b.emp_name
order by sum(c.score) desc limit 1;