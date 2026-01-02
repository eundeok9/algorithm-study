-- 코드를 입력하세요
select id, name, host_id
from places
where host_id in (select host_id from places group by host_id having count(id) >= 2)
order by id;

-- 둘 이상 공간 등록한 유저