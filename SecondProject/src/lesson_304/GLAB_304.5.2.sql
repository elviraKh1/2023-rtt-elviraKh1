--Example: “OR” Operator Examples
SELECT    customername, country
FROM    customers
WHERE    country = 'USA' OR country = 'France'

--Example: “AND” Operator Examples
SELECT    customername, country, creditLimit
FROM    customers
WHERE (country = 'USA' OR country = 'France') AND creditlimit > 100000;

--Example: BETWEEN and NOT BETWEEN
SELECT     productCode,  productName,  buyPrice
FROM    products
WHERE     buyPrice BETWEEN 90 AND 100;

SELECT productCode, productName, buyPrice
FROM products
WHERE  buyPrice >= 90 AND buy Price <= 100;

SELECT productCode, productName, buyPrice FROM products
WHERE buyPrice NOT BETWEEN 20 AND 100;

--Example:  “IS NULL” Operator

SELECT customerName, country, salesrepemployeenumber
FROM customers
WHERE salesrepemployeenumber IS NULL
ORDER BY  customerName;

-- query uses the LEFT JOIN predicate and the IS NULL operator  to find customers who have no order:

SELECT  c.customerNumber, c.customerName,  orderNumber, o.STATUS
FROM customers c
LEFT JOIN orders o
ON c.customerNumber = o.customerNumber
WHERE  orderNumber IS NULL;
