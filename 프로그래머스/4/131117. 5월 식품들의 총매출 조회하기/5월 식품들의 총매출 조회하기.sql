select p.product_id, p.product_name, sum(p.price * o.amount) as total_sales
from food_product as p, food_order as o
where p.product_id = o.product_id and o.produce_date like '2022-05%'
group by product_id
order by total_sales desc, product_id;
