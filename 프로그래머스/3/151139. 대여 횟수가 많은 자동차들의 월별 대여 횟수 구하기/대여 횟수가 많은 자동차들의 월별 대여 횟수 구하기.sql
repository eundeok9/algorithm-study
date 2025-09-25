SELECT month(start_date) as month, car_id, count(*) as records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where year(start_date) = 2022 and month(start_date) between 8 and 10
    and car_id in 
    (select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY
     where year(start_date) = 2022 and month(start_date) between 8 and 10
     group by car_id
     having count(*) >= 5
    )
group by car_id, month(start_date)
having count(*) >= 1
order by month, car_id desc;