-- 코드를 작성해주세요
select a.id, (
    select count(*)
    from ecoli_data as b
    where a.id = b.parent_id
) as child_count
from ecoli_data as a
order by a.id;