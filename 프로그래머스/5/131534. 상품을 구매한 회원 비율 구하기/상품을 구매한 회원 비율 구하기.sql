-- 코드를 입력하세요
SELECT 
    year(sales_date) as YEAR,
    month(sales_date) as MONTH,
    count(distinct user_id) as PURCHASED_USERS,
    round(
        count(distinct user_id) / (
            select count(*) from user_info where year(joined) like '2021'
            )
        , 1) as PURCHASED_RATIO
FROM ONLINE_SALE
WHERE user_id in (select user_id from user_info where year(joined) like '2021')
GROUP BY year, month
order by year, month;