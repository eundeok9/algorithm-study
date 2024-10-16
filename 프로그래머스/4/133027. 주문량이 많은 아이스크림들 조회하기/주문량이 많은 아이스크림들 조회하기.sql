-- 코드를 입력하세요
with july_total as (
    select flavor, sum(total_order) as total
    from july
    group by flavor
),
first_half_total as (
    select flavor, sum(total_order) as total
    from first_half
    group by flavor
)

select a.flavor
from july_total as a, first_half_total as b
where a.flavor = b.flavor
group by a.flavor
order by sum(a.total+ b.total) desc
limit 3;