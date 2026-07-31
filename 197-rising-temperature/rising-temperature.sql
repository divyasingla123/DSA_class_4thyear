# Write your MySQL query statement below
with cte as(select id,temperature,recordDate from Weather)
select cte.id from Weather w join cte on DATEDIFF(cte.recordDate,w.recordDate)=1 where cte.temperature>w.temperature;