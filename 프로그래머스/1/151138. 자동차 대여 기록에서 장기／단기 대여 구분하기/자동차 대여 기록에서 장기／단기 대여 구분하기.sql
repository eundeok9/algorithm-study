-- 코드를 입력하세요
SELECT 
    history_id,
    car_id,
    Date_format(start_date, "%Y-%m-%d") as start_date,
    Date_format(end_date, "%Y-%m-%d") as end_date,
    case
        when DATEDIFF(end_date, start_date) + 1 >= 30 then '장기 대여'
        else '단기 대여'
    end as rent_type
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where year(start_date) = 2022 and month(start_date) = 9
order by history_id desc;