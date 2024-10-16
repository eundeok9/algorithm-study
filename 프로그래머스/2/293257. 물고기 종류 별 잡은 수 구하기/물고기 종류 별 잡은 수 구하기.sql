-- 코드를 작성해주세요
select count(id) as fish_count, fish_name
from fish_info as a, fish_name_info as b
where a.fish_type = b.fish_type
group by b.fish_name
order by fish_count desc;