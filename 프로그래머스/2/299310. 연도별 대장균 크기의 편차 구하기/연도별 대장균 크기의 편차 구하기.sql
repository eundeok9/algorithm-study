with max_size_of_the_year as (
    select year(DIFFERENTIATION_DATE) as year, max(SIZE_OF_COLONY) as max_size from ecoli_data group by year(DIFFERENTIATION_DATE)
)
select year(DIFFERENTIATION_DATE) as year, (max_size - size_of_colony) as year_dev, id
from ecoli_data as a
join max_size_of_the_year as b
on year(a.DIFFERENTIATION_DATE) = b.year
order by year(a.DIFFERENTIATION_DATE), year_dev;