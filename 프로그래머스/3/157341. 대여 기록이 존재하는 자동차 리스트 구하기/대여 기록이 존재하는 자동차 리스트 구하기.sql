-- 코드를 입력하세요
SELECT distinct a.car_id
from car_rental_company_car as a, car_rental_company_rental_history as b
where a.car_id = b.car_id and car_type like '세단' and start_date like '2022-10%'
order by car_id desc;