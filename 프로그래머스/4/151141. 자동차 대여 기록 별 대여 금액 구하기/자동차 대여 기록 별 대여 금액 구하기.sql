-- 코드를 입력하세요
with value as (
    select
        car.daily_fee,
        car.car_type,
        his.history_id,
        datediff(end_date, start_date) + 1 as period,
        case 
            when datediff(end_date, start_date) + 1 >= 90 then '90일 이상'
            when datediff(end_date, start_date) + 1 >= 30 then '30일 이상'
            when datediff(end_date, start_date) + 1 >= 7 then '7일 이상'
            else 'NONE' end as duration_type
from CAR_RENTAL_COMPANY_RENTAL_HISTORY as his
inner join CAR_RENTAL_COMPANY_CAR as car on car.car_id = his.car_id
where car.car_type = '트럭'
)
select
    value.history_id,
    round(value.daily_fee * value.period * (100 - IFNULL(plan.DISCOUNT_RATE, 0)) / 100) as fee
from value
left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as plan
on plan.duration_type = value.duration_type
and plan.car_type = value.car_type
order by fee desc, value.history_id desc;
