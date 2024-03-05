-- 코드를 작성해주세요
select ID, EMAIL, FIRST_NAME, LAST_NAME from developers
WHERE skill_code & (select code from skillcodes where name = 'C#')
OR skill_code & (select code from skillcodes where name = 'Python')
order by id