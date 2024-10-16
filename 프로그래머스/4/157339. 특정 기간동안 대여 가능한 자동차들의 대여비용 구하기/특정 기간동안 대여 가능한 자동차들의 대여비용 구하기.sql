-- 코드를 입력하세요
SELECT a.car_id, a.car_type, round((a.daily_fee * (1 - c.discount_rate / 100)) * 30) as fee
from CAR_RENTAL_COMPANY_CAR as a, CAR_RENTAL_COMPANY_RENTAL_HISTORY as b, CAR_RENTAL_COMPANY_DISCOUNT_PLAN as c
where a.car_id = b.car_id
and a.car_type in ('세단', 'SUV')
and c.duration_type like '30일 이상'
and a.car_type = c.car_type
and b.car_id not in (
    select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where end_date > '2022-11-01' and start_date < '2022-12-01'
)
group by car_id
having fee between 500000 and 1999999
order by fee desc, car_type, car_id


