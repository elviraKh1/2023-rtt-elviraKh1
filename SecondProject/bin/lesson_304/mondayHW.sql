-- 1) I want to see a list of customer names and the order number for any orders that have made an order that has an order_date greater than the latest payment date -
-- will require a sub query to get the max(payment_date) for the customer which can be used in the where lause to find orders with an order_date after the max(payment_date)

select c.customer_name, o.id, o.order_date
from customers c , orders o
where c.id = o.customer_id
and o.order_date > (select max(p.payment_date) from payments p);

-- 1a) I want to see a list of customer names and the payment number for any payments that have made an payment that has an payment_date greater than the latest order date -
select c.customer_name, p.id ,p.payment_date
from customers c , payments p
where c.id = p.customer_id
and p.payment_date> (select max(o.order_date ) from orders o ); -- '2005-05-31'

-- 2) I want to see all the employees that are working in an office where the state is not null;
select e.* -- , o.*
from employees e, offices o
where o.id=e.office_id
and o.state is not null;

-- 3) I want to all of the products that are not ground vehicles.   Hint -  where not in a select statement from product line
select p.*, pl.product_line
from products p, productlines pl
where p.productline_id = pl.id
and pl.id in (3,4,5) -- '3', 'Planes' '4', 'Ships' '5', 'Trains'
order by product_line, p.product_name;

-- 3a) I want to see a unique list of the order status
select distinct status from orders order by status asc;

-- 4) use an IN statement with a sub query - I want to see the list of products that have been ordered but not yet shipped. - the orders table has a status column that contins the order status
-- select  distinct status from orders o where o.shipped_date is null ; -- canceled  on hold  in process
-- select  distinct status from orders o where o.shipped_date is not null ; --  Shipped Resolved Cancelled Disputed
select *
from  products p , orders o , orderdetails od
where  p.id = od.product_id
and o.id=od.order_id
and o.shipped_date is null
and o.status in ('in process', 'on hold'); -- , 'canceled');

-- 5) The product name, and quantity ordered for all orders that are on holed or in process
select p.product_name, od.quantity_ordered
from  products p , orders o , orderdetails od
where  p.id = od.product_id
and o.id=od.order_id
and o.status in ('in process', 'on hold');

-- 6) I want to see a list of all employess that do not have a customer!!!!  use a where not in ( select employee_id from customer where .... )
-- select empl.* from employees empl
-- where empl.id not in (select distinct c2.sales_rep_employee_id  from customers c2 );

SELECT *
FROM employees e
LEFT JOIN (select distinct c2.sales_rep_employee_id  from customers c2 ) sales_rep_employee
  ON e.id= sales_rep_employee.sales_rep_employee_id
WHERE  sales_rep_employee.sales_rep_employee_id IS NULL;

-- 6a) I want to see the employee name and each of their customer names.   IF the employee does not have any customers then show null for the customer name ... this is a left join
--    order this by the employee first name asc    you will see the employee name repeated many times for each customer they have .. but if the employee has no customers it should print NULL in
--    the second column.
select concat(e.firstname,' ', e.lastname) as employee_name  ,   concat(c.contact_firstname,' ', c.contact_lastname) as customer_name
from employees e left join customers c on e.id=c.sales_rep_employee_id
order by 1,2;
