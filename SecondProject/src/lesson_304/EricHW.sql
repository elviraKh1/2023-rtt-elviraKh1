-- 1 For each customer show the customer name, the total number of payments
select c.id, c.customer_name, count(*) as number_payments from payments p, customers c where  c.id = p.customer_id group by p.customer_id order by number_payments desc;

-- 2 For each customer show the customer name and the total amount paid
select c.id, c.customer_name, sum(p.amount) as total_amount from payments p, customers c where  c.id = p.customer_id group by p.customer_id order by total_amount desc;

-- 3 for each emoployee show the employee name and the total number of customers that employee has
select e.id,  CONCAT(e.firstname ,' ',e.lastname) as name, count(*) as total_customers from employees e, customers c where e.id =c.sales_rep_employee_id group by e.id order by total_customers desc;

-- 4 for each office, show the office name, the total number of employees in that office, and the total number of customers
SELECT
    CONCAT(o.city,' ',o.country) as office_name,
    (SELECT COUNT(*) FROM employees e WHERE e.office_id = o.id) AS total_employees,
    (SELECT COUNT(*) FROM customers c WHERE c.sales_rep_employee_id IN (SELECT id FROM employees e2 WHERE e2.office_id = o.id)) AS total_customers
FROM
    offices o;

-- 5) for each office, I want to see office name and the total number quantity of products ordered

select o.city from offices o ;

select ofc.city, sum(od.quantity_ordered) from orderdetails od, orders o, customers c , offices ofc where o.id=od.order_id  and c.id= o.customer_id and c.sales_rep_employee_id  IN (SELECT id FROM employees e2 WHERE e2.office_id = ofc.id) group by ofc.city ;

 -- SELECT c.id, ofc.city FROM customers c,  offices ofc WHERE c.sales_rep_employee_id IN (SELECT id FROM employees e2 WHERE e2.office_id = ofc.id and ofc.id=1) ;
 select ofc.city, sum(od.quantity_ordered) from orderdetails od, orders o where o.id=od.order_id  and o.customer_id in (SELECT c.id FROM customers c,  offices ofc WHERE c.sales_rep_employee_id IN (SELECT id FROM employees e2 WHERE e2.office_id = ofc.id ) ;