-- 코드를 작성해주세요

-- rare인 아이템의 다음 업그레이드 아이템

-- 0, 1, 3, 4
-- 0 -> 1, 2
-- 1 -> 3, 4

select c.item_id, c.item_name, c.rarity
from item_info as a, item_tree as b, item_info as c
where a.item_id = b.parent_item_id and a.rarity = 'rare' and b.item_id = c.item_id
order by item_id desc;