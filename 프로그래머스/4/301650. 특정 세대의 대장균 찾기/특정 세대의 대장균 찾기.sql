-- 코드를 작성해주세요
select a.id
from ecoli_data as a, ecoli_data as b, ecoli_data as c
where a.parent_id = b.id and b.parent_id = c.id and c.parent_id is null
order by a.id;


-- 1세대(parent_id = null): 1, 2
-- 2세대(parent_id = 1 or 2): 3, 4, 5
-- 3세대(parent_id = 3 or 4 or 5): 6, 7
-- 4세대(parent_id = 6 or 7): 8

-- parent_id의 parent_id가 null
-- a, b, c
