select name from SalesPerson where name not in (

select t1.name from SalesPerson as t1
join Orders as t2
on t1.sales_id = t2.sales_id
join Company as t3
on t2.com_id = t3.com_id
where t3.name = "RED"

)