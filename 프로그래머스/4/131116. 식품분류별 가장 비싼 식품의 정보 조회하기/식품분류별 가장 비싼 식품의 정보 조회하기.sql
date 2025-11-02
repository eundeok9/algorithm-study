-- 코드를 입력하세요
SELECT category, price as max_price, product_name
from food_product
where category in ('과자', '국', '김치', '식용유') and
price in (select max(price) from food_product group by category)
order by price desc;


