-- 코드를 작성해주세요
SELECT ID, FISH_NAME, LENGTH
FROM (
  SELECT FI.ID, FNI.FISH_NAME, FI.LENGTH,
         ROW_NUMBER() OVER (
           PARTITION BY FI.FISH_TYPE
           ORDER BY FI.LENGTH DESC
         ) rn
  FROM FISH_INFO FI
  JOIN FISH_NAME_INFO FNI
    ON FI.FISH_TYPE = FNI.FISH_TYPE
) t
WHERE rn = 1
ORDER BY ID;

-- 종류 별로 가장 큰 물고기 id, 이름, 길이
-- 물고기 id 오름차순