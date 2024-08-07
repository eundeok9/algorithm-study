WITH FIRST AS (
    SELECT ID
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
),
SECOND AS (
    SELECT ecoli_data.id, ecoli_data.parent_id
    FROM ECOLI_DATA, first
    WHERE FIRST.ID = ECOLI_DATA.PARENT_ID
)

select ecoli_data.id
from ecoli_data, second
where ecoli_data.parent_id = second.id