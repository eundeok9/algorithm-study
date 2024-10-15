-- 코드를 작성해주세요
select count(*) as count
from ecoli_data
where (genotype & 2) != 2 and ((genotype & 4) = 4 or (genotype & 1) = 1);