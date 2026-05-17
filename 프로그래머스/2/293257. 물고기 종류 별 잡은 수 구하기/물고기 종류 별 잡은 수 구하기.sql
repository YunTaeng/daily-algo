-- 코드를 작성해주세요
select count(I.FISH_TYPE) as FISH_COUNT, N.FISH_NAME as FISH_NAME
from FISH_INFO I
join FISH_NAME_INFO N on I.FISH_TYPE = N.FISH_TYPE
group by I.FISH_TYPE
order by FISH_COUNT desc