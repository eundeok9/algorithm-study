-- 코드를 작성해주세요
select c.item_id, c.item_name, c.rarity
from item_info as a
join item_tree as b
join item_info as c
where a.rarity = 'RARE' and a.item_id = b.PARENT_ITEM_ID and b.item_id = c.item_id
order by c.item_id desc;

-- 희귀도가 'rare' 인 아이템들의 다음 업그레이드 아이템?

-- rare인 아이템
-- item_id -> parent_item_id
-- item_a (0) -> item_b, item_c
-- item_b (1) -> item_d, item_e
-- item_d (2) -> 더이상 x
-- item_e (2) -> 더이상 x