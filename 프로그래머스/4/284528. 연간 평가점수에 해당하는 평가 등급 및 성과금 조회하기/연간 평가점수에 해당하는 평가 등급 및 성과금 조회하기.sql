-- 코드를 작성해주세요
select
    E.EMP_NO,
    E.EMP_NAME, 
    CASE
        WHEN avg(G.SCORE) >= 96 THEN 'S'
        WHEN avg(G.SCORE) >= 90 THEN 'A'
        WHEN avg(G.SCORE) >= 80 THEN 'B'
        ELSE 'C'
    END as GRADE,
    CASE
        WHEN avg(G.SCORE) >= 96 THEN E.SAL * 0.2
        WHEN avg(G.SCORE) >= 90 THEN E.SAL * 0.15
        WHEN avg(G.SCORE) >= 80 THEN E.SAL * 0.1
        ELSE 0
    END as BONUS
from HR_EMPLOYEES as E
join HR_DEPARTMENT as D on E.DEPT_ID = D.DEPT_ID
join HR_GRADE as G on E.EMP_NO = G.EMP_NO
group by E.EMP_NO
order by E.EMP_NO