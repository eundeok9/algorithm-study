-- 코드를 입력하세요
SELECT a.flavor
from first_half as a
join july as b on a.flavor = b.flavor
group by flavor
order by a.total_order+sum(b.total_order) desc
limit 3;


-- 7월 아이스크림 총 주문량
-- + 상반기 아이스크림 총 주문량