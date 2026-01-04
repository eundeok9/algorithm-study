-- 코드를 작성해주세요
select concat(quarter(DIFFERENTIATION_DATE), 'Q') as quarter, count(id) as ecoli_count
from ecoli_data
group by concat(quarter(DIFFERENTIATION_DATE), 'Q')
order by quarter

-- 각 분기에 분화된 대장균 개체의 총 수