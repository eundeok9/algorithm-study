-- 코드를 입력하세요
SELECT user.user_id, user.nickname, sum(price) as total_sales
from USED_GOODS_BOARD as board left join USED_GOODS_USER as user on board.writer_id = user.user_id
where status = 'DONE'
group by user.user_id
having sum(price) >= 700000
order by sum(price);
