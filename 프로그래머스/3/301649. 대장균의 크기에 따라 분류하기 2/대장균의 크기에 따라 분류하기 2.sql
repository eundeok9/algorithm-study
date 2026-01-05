-- 코드를 작성해주세요
-- 대장균 개체의 크기를 내림차순으로 정렬했을 때
select id, 
    case 
        when size_group = 1 then 'CRITICAL'
        when size_group = 2 then 'HIGH'
        when size_group = 3 then 'MEDIUM'
        else 'LOW'
    end as colony_name
from (
    select 
        id,
        ntile(4) over (order by SIZE_OF_COLONY desc) as size_group
    from ecoli_data
) ecoli_size_group
order by id;