-- 코드를 작성해주세요
with ecoli_child_data as (
    select parent_id, count(parent_id) as child_count from ecoli_data group by parent_id
)

select id, ifnull(child_count,0) as child_count
from ecoli_data as a
left join ecoli_child_data as b
on a.id = b.parent_id
order by id;