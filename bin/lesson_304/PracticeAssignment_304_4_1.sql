-- 1 Display the name, product line, and buy price of all products. The output columns should display as: “Name,” “Product Line,” and “Buy Price.” The output should display the most expensive items first.

select product_name as Name, productline_id as "Product Line", buy_price as "Buy Price" from products order by buy_price desc;

-- 2 Display the first name, last name, and city name of all customers from Germany. The output columns should display as: “First Name,” “Last Name,” and “City.” The output should be sorted by “Last Name” (ascending).
select contact_firstname as "First Name", contact_lastname as "Last Name", city as "City Name" from customers c where c.country = "Germany" order by c.contact_lastname asc;

-- 3 Display each of the unique values of the status field in the orders table. The output should be sorted alphabetically, ascending.
select distinct status from orders order by status asc;

-- 4 Display all fields from the payments table for payments made on or after January 1, 2005. The output should be sorted by the payment date from highest to lowest.
select * from payments p where p.payment_date >= '2005-01-01' order by payment_date desc;

-- 5 Display the last Name, first Name, email address, and job title of all employees working out of the San Francisco office. The output should be sorted by “Last Name.”
select e.lastname as 'Last Name', e.firstname as 'First Name', e.email as 'Email Address', e.job_title as 'Job Title'
from employees e, offices o
where e.office_id = o.id and o.city ='San Francisco' order by 1;

-- 6 Display the name, product line, scale, and vendor of all of the car products – both classic and vintage. The output should display all vintage cars first (sorted alphabetically by name), and all classic cars last (also sorted alphabetically by name).
select p.product_name , pl.product_line , p.product_scale , p.product_vendor
from products p, productlines pl
where productline_id = pl.id  and pl.product_line in ('Vintage Cars' , 'Classic Cars')
order by pl.product_line desc, p.product_name asc;