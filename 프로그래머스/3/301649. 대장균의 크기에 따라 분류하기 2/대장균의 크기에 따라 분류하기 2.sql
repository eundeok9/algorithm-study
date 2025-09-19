select a.id,
    CASE
        WHEN a.per <= 0.25 THEN "CRITICAL"
        WHEN a.per <= 0.5 THEN "HIGH"
        WHEN a.per <= 0.75 THEN "MEDIUM"
        ELSE "LOW"
    END as COLONY_NAME
FROM (
    SELECT ID, PERCENT_RANK() over (order by size_of_colony desc) as per FROM ECOLI_DATA
) as a
ORDER BY a.ID;
