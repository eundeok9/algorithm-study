
-- 코드를 작성해주세요
SELECT ID, FISH_NAME, LENGTH
FROM FISH_INFO as a
JOIN FISH_NAME_INFO as b
ON a.fish_type = b.fish_type
WHERE a.fish_type in (select fish_type from fish_info group by fish_type having length = max(length))
order by id;