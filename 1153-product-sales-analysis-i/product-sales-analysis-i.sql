# Write your MySQL query statement below
select Product.product_Name,Sales.year,Sales.price from Sales left join Product on Sales.product_id=Product.product_id;