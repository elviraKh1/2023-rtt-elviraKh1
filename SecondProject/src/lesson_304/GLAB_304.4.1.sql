--The following query selects the order line items from the orderdetails table. It calculates the subtotal for each line item, and sorts the result based on the subtotal.
SELECT    orderNumber, orderlinenumber, quantityOrdered * priceEach
FROM    orderdetails
ORDER BY   quantityOrdered * priceEach DESC;

-- column alias in the ORDER BY clause:
SELECT
    orderNumber,
    orderLineNumber,
    quantityOrdered * priceEach AS subtotal
FROM    orderdetails
ORDER BY subtotal DESC;

--  when you use the ORDER BY clause with the ASC option, NULLs appear first in the result set.
SELECT    firstName, lastName, reportsTo
FROM    employees
ORDER BY reportsTo;

-- ORDER BY clause with the DESC option, NULLs will appear last in the result set.
SELECT    firstName, lastName, reportsTo
FROM    employees
ORDER BY reportsTo DESC;


