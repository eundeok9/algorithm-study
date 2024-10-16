-- 코드를 작성해주세요
select item_id, item_name, rarity
from item_info
where item_id not in (
    select a.item_id from item_info as a, item_tree as b
    where a.item_id = b.parent_item_id
)
order by item_id desc;