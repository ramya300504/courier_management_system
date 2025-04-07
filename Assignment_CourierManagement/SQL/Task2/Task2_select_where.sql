-- 1. List all customers:  
select name from User;

-- 2. List all orders for a specific customer:
select * from courier where SenderName='Arun Kumar';

-- 3. List all couriers:  
select * from courier;

-- 4. List all packages for a specific order:  
select * from courier where CourierID=8;

-- 5. List all deliveries for a specific courier: 
select * from courier where CourierID=5 and CourierID=6 and DeliveryDate is not null;

-- 6. List all undelivered packages:  
select * from courier where status!='Delivered';

-- 7. List all packages that are scheduled for delivery today:
select * from courier where DeliveryDate=curdate();

-- 8. List all packages with a specific status:  
select * from courier where status='In Transit';
select * from courier where status='Shipped';

-- 9. Calculate the total number of packages for each courier.  
SELECT COUNT(*) AS TotalPackages
FROM Courier 
group by SenderName;


-- 10. Find the average delivery time for each courier  
SELECT c.CourierID, 
       AVG(DATEDIFF(DeliveryDate, PaymentDate)) AS AvgDeliveryTime
FROM Courier c 
join payment p on c.CourierID=p.PaymentID
group by c.CourierID;

-- 11. List all packages with a specific weight range:  
select * from courier where Weight between 2.00 and 5.00;

-- 12. Retrieve employees whose names contain 'John'  
select * from employee where Name like '%John%';

-- 13. Retrieve all courier records with payments greater than $50. 
select c.* from courier c join payment p 
on c.CourierID=p.CourierID
where Amount>50;  
