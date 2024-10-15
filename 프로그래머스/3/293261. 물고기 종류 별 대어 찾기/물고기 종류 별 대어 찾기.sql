-- 코드를 작성해주세요
select id, fish_name, length
from fish_info as a, fish_name_info as b
where a.fish_type = b.fish_type and a.fish_type in (
    select fish_type
    from fish_info
    group by fish_type
    having length = max(length)
)
order by id