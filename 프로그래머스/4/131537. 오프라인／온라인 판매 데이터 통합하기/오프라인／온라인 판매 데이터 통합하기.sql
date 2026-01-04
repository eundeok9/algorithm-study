-- 코드를 입력하세요
(select date_format(sales_date, '%Y-%m-%d') as sales_date, product_id, user_id, sales_amount
from ONLINE_SALE
where date_format(sales_date, '%Y-%m-%d') >= '2022-03-01' and date_format(sales_date, '%Y-%m-%d') <'2022-04-01')
union all
(select date_format(sales_date, '%Y-%m-%d') as sales_date, product_id, NULL, sales_amount
from OFFLINE_SALE
where date_format(sales_date, '%Y-%m-%d') >= '2022-03-01' and date_format(sales_date, '%Y-%m-%d') <'2022-04-01')
order by sales_date asc, product_id asc, user_id asc