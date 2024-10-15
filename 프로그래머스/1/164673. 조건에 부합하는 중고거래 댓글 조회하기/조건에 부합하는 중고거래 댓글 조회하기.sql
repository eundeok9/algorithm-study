-- 코드를 입력하세요
SELECT title, a.board_id, reply_id, b.writer_id, b.contents, date_format(b.created_date, '%Y-%m-%d') as created_date
from USED_GOODS_BOARD as a, USED_GOODS_REPLY as b
where a.board_id = b.board_id and date_format(a.created_date, '%Y-%m') like '2022-10'
order by created_date, title
;