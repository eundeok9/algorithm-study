-- 코드를 입력하세요
SELECT title, B.board_id, R.reply_id, R.writer_id, R.contents, date_format(R.created_date, '%Y-%m-%d')
FROM USED_GOODS_BOARD as B
JOIN USED_GOODS_REPLY as R ON B.BOARD_ID = R.BOARD_ID
WHERE year(B.CREATED_DATE) = 2022 and month(B.CREATED_DATE) = 10
order by R.CREATED_DATE, title;