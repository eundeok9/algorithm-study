-- 코드를 입력하세요
SELECT ID, NAME, HOST_ID
FROM PLACES
WHERE HOST_ID IN (SELECT HOST_ID from places
                    group by host_id
                    having count(*) > 1
                  )
ORDER BY ID;
