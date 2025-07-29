-- 코드를 입력하세요
SELECT year(SALES_DATE) as year, month(SALES_DATE) as month, gender, count(distinct a.user_id) as users
from USER_INFO as a
join ONLINE_SALE as b on a.user_id = b.user_id
where gender is not null
group by year(SALES_DATE), month(SALES_DATE), gender
order by year(SALES_DATE), month(SALES_DATE), gender