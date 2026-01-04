-- 코드를 입력하세요
SELECT title, a.board_id, reply_id, b.writer_id, b.contents, date_format(b.created_date, '%Y-%m-%d') as created_date
from used_goods_board as a
join used_goods_reply as b
on a.board_id = b.board_id
WHERE year(a.CREATED_DATE) = 2022 and month(a.CREATED_DATE) = 10
order by b.created_date, title;