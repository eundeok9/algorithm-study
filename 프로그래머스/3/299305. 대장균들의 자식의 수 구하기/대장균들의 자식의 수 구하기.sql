-- 코드를 작성해주세요
select id, (select count(*) from ecoli_data e2 where e2.parent_id = e1.id) as child_count
from ecoli_data e1
order by id;
