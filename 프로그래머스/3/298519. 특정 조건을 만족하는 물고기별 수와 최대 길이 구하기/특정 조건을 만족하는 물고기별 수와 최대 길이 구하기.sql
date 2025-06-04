-- 코드를 작성해주세요
with fish_length_with_33 as (
    select fish_type from fish_info
    group by fish_type
    having avg(greatest(length,10)) >= 33
)

select count(id) as fish_count, max(length) as max_length, a.fish_type
from fish_info as a, fish_length_with_33 as b
where a.fish_type = b.fish_type
group by a.fish_type
order by a.fish_type;