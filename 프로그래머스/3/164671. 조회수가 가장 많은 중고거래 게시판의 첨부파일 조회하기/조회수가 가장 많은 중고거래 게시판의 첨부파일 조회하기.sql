-- 코드를 입력하세요
SELECT concat('/home/grep/src/', file.board_id, '/', file_id, file_name, file_ext) as file_path
from USED_GOODS_BOARD as board, USED_GOODS_FILE as file
where board.board_id = file.board_id and views = (
    select views from USED_GOODS_BOARD order by views desc limit 1
)
order by file_id desc;