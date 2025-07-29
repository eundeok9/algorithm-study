-- 코드를 입력하세요
SELECT a.APNT_NO, p.PT_NAME, p.PT_NO, d.MCDP_CD, d.DR_NAME, a.APNT_YMD
FROM PATIENT as p
join APPOINTMENT as a on p.pt_no = a.pt_no
join DOCTOR as d on a.MDDR_ID = d.DR_ID
where
    a.MCDP_CD like 'CS'
    and a.APNT_CNCL_YN like 'N'
    and DATE(APNT_YMD) = '2022-04-13'
order by apnt_ymd asc;