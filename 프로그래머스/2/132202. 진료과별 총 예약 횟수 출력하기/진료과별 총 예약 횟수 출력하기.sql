-- 코드를 입력하세요
SELECT mcdp_cd as '진료과코드', count(*) as '5월예약건수'
FROM appointment
where apnt_ymd like '2022-05%'
group by mcdp_cd
order by count(*), mcdp_cd;