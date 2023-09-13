-- 코드를 입력하세요
((select left(sales_date,10) as 'SALES_DATE', product_id, user_id, sales_amount
from online_sale
where sales_date like '2022-03%')
union ALL
(select left(sales_date, 10) as 'SALES_DATE', product_id, NULL AS USER_ID, sales_amount
 from offline_Sale
 where sales_date like '2022-03%'))
 order by sales_date asc, product_id asc, user_id asc
