-- 코드를 작성해주세요
select a.item_id, item_name
from item_info as a, item_tree as b
where a.item_id = b.item_id and b.parent_item_id is null
order by a.item_id;