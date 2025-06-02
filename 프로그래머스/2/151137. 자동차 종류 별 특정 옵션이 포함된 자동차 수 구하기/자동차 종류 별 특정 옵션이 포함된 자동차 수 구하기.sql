-- 코드를 입력하세요
SELECT car_type, count(options) as cars
from CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%열선시트%' OR OPTIONS LIKE '%통풍시트%' OR OPTIONS LIKE '%가죽시트%'
GROUP BY car_type
order by car_type;