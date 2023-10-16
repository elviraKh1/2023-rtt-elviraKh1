--statement finds whether the quantity of products, which customers ordered, is odd or even.
SELECT orderNumber, SUM(quantityOrdered) as Qty,
    IF(MOD(SUM(quantityOrdered),2),'Odd', 'Even') as oddOrEven
FROM    orderdetails
GROUP BY    orderNumber
ORDER BY    orderNumber;

--TRUNCATE() with a positive number of decimal places
SELECT TRUNCATE(1.555,1);

--query finds the average order line item values by product codes:
SELECT productCode, AVG(quantityOrdered * priceEach) as avg_order_value
FROM orderDetails
GROUP BY productCode;

--TRUNCATE() and ROUND() function for comparison:
SELECT   TRUNCATE(1.999,1),  ROUND(1.999,1);

--REPLACE() function in an UPDATE statement is as follows:
UPDATE tbl_name SET field_name = REPLACE(field_name, string_to_find, string_to_replace) WHERE    conditions;
UPDATE products SET productDescription = REPLACE(productDescription,'abuot','about');

--some examples of using the DATEDIFF()  function.
SELECT DATEDIFF('2011-08-17','2011-08-17');
--#Result  :   0 day
SELECT DATEDIFF('2011-08-17','2011-08-08');
--#Result:  9 days
SELECT DATEDIFF('2011-08-08','2011-08-17');
--#Result:  9 days

--DATE_FORMAT() with the ORDER BY clause
SELECT     orderNumber,
    DATE_FORMAT(shippeddate, '%W %D %M %Y')  as 'Shipped date'
FROM    orders
ORDER BY shippeddate;

-- LPAD() function left-pads a string with another string to a certain length.
SELECT LPAD('hi',4,'??');      -- #Result   -> '??hi'
SELECT LPAD('hi',1,'??');     -- # Result -> 'h'
SELECT firstName, LPAD(firstName,10,'kk'), LPAD(firstName,5,'kk'), LPAD(firstName,4,'kk') FROM classicmodels.employees;

--TRIM to help you clean up the data. The following illustrates the syntax of the TRIM function.
TRIM([{BOTH|LEADING|TRAILING} [removed_str]] FROM str);
SELECT TRIM(' SQL TRIM Function ');
-- The DAY() function returns the day of the month of a given date.
SELECT  DAY(orderdate) as dayofmonth, COUNT(*)
FROM    orders WHERE    YEAR(orderdate) = 2004
GROUP BY dayofmonth
ORDER BY dayofmonth;
-- The YEAR() function takes a date argument and returns the year of the date.
SELECT YEAR('2002-01-01');



