-- 코드를 입력하세요
SELECT a.author_id, author_name, category, sum(s.sales * b.price) as total_sales
from book as b, author as a, book_sales as s
where b.author_id = a.author_id and b.book_id = s.book_id and year(sales_date) = 2022 and month(sales_date) = 1
group by a.author_id, category
order by a.author_id asc, category desc;