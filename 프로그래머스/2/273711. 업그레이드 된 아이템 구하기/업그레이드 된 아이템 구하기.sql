-- 코드를 작성해주세요
select item_id, item_name, rarity
from item_info
where item_id in (
    -- a가 parent, b는 child
    select b.item_id from item_info a, item_tree b
    where a.item_id = b.parent_item_id and a.rarity = 'RARE'
)
order by item_id desc;