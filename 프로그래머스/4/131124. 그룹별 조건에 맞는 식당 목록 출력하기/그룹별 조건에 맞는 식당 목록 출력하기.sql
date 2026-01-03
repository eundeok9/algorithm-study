-- 코드를 입력하세요
with review_count as (select member_id, count(*) from rest_review group by member_id order by count(*) desc)
SELECT member_name, review_text, date_format(review_date, '%Y-%m-%d') as review_date
from MEMBER_PROFILE as a
join REST_REVIEW as b on a.MEMBER_ID = b.MEMBER_ID
where a.MEMBER_ID = (select member_id from review_count limit 1)
order by review_date, review_text;

-- 리뷰를 가장 많이 작성한 회원의 리뷰들
