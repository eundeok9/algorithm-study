select id, (select count(*) from ecoli_data as e2 where e2.parent_id = e1.id) as child_count
from ecoli_data e1
order by id;