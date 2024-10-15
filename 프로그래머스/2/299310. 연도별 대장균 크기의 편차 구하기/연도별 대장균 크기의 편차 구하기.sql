-- 코드를 작성해주세요
SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR,
(
    SELECT MAX(size_of_colony) FROM ecoli_data
    WHERE YEAR(DIFFERENTIATION_DATE) = YEAR
) - size_of_colony AS year_dev,
id
from ecoli_data
order by year, year_dev