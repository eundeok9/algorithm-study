-- 부서별 평균 연봉 (소수점 첫째 자리 반올림)
-- 부서별 평균 연봉 내림차순 정렬
select HR_DEPARTMENT.dept_id, dept_name_en, round(avg(sal), 0) as avg_sal
from HR_DEPARTMENT
join HR_EMPLOYEES on HR_DEPARTMENT.dept_id = HR_EMPLOYEES.dept_id
group by HR_DEPARTMENT.dept_id
order by avg_sal desc;