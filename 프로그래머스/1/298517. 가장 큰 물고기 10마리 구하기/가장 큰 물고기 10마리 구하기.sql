-- 코드를 작성해주세요
with ranked_fish as (
    select id, length, row_number() over(order by length desc, id) as rn
    from fish_info
)

select id, length
from ranked_fish
where rn <= 10;

-- limit을 사용하는 방법
# select id, length
# from fish_info
# order by length desc, id
# limit 10;
