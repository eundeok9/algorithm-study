SELECT rest_info.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, ROUND(avg(review_SCORE),2) as score
from rest_info, rest_review
where rest_info.rest_id = rest_review.rest_id
group by rest_id
having address like "서울%"
ORDER BY SCORE DESC, favorites DESC