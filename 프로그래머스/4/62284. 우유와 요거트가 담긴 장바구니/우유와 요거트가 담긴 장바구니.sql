-- 코드를 입력하세요
SELECT distinct a.cart_id
from cart_products as a, cart_products as b
where a.cart_id = b.cart_id and a.id != b.id and a.name = "Milk" and b.name = "Yogurt"
order by a.cart_id;