-- 코드를 작성해주세요
select id, fish_name, length
from (
    select id, fish_name, length, row_number() over (partition by a.fish_type order by length desc) as rn
    from fish_info as a
    join fish_name_info as b on a.fish_type = b.fish_type
) as t
where rn = 1
order by id;