-- 코드를 작성해주세요
SELECT a.id, a.genotype, b.genotype as parent_genotype
FROM ecoli_data a, ecoli_data b
where a.parent_id = b.id and (a.genotype & b.genotype) = b.genotype
order by id;
-- a가 자식 b가 부모
