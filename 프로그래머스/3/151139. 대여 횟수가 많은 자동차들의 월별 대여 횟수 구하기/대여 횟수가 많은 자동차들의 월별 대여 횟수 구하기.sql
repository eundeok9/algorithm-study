-- 코드를 입력하세요
SELECT month(start_date) as month, car_id, count(*) as records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_date >= '2022-08-01' and start_date < '2022-11-01'
and car_id in (
    select car_id from car_rental_company_rental_history
    where start_date >= '2022-08-01' and start_date < '2022-11-01'
    group by car_id
    having count(*) >= 5
)
group by car_id, month(start_date)
having count(*) >= 1
order by month(start_date), car_id desc;
-- 2022년 8월부터 10월까지 총 대여 횟수가 5회 이상인 자동차
-- 월별 자동차 ID별 총 대여횟수
-- 월 기준 오름차순, 자동차 ID 기준 내림차준
-- 월 대여 횟수가 0인 경우 제외
-- 코드를 입력하세요
