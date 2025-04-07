-- creating user table and inserting data 

CREATE TABLE User (
    UserID INT PRIMARY KEY, 
    Name VARCHAR(255) NOT NULL, 
    Email VARCHAR(255) UNIQUE NOT NULL, 
    Password VARCHAR(255) NOT NULL, 
    ContactNumber VARCHAR(20), 
    Address TEXT
);

INSERT INTO User (UserID, Name, Email, Password, ContactNumber, Address) 
VALUES 
(1001, 'Arun Kumar', 'arunkumar@gmail.com', 'Arun@123', '9876543210', 'Anna Nagar, Chennai, Tamil Nadu'),
(1002, 'Priya Raj', 'priyaraj@gmail.com', 'Priya@456', '8765432109', 'Gandhipuram, Coimbatore, Tamil Nadu'),
(1003, 'Vikram R', 'vikramr@gmail.com', 'Vikram@789', '7654321098', 'KK Nagar, Madurai, Tamil Nadu'),
(1004, 'Divya Shree', 'divyashree@gmail.com', 'Divya@101', '9543210987', 'Sathyamangalam, Erode, Tamil Nadu'),
(1005, 'Karthik S', 'karthiks@gmail.com', 'Karthik@202', '8432109876', 'Race Course, Trichy, Tamil Nadu'),
(1006, 'Meena Lakshmi', 'meenalakshmi@gmail.com', 'Meena@303', '9321098765', 'Kovaipudur, Coimbatore, Tamil Nadu'),
(1007, 'Sundar C', 'sundarc@gmail.com', 'Sundar@404', '9210987654', 'Simmakkal, Madurai, Tamil Nadu'),
(1008, 'Revathi R', 'revathir@gmail.com', 'Revathi@505', '8109876543', 'MGR Nagar, Salem, Tamil Nadu'),
(1009, 'Ravi Kumar', 'ravikumar@gmail.com', 'Ravi@606', '9098765432', 'Gandhi Street, Vellore, Tamil Nadu'),
(1010, 'Anitha P', 'anithap@gmail.com', 'Anitha@707', '9988776655', 'Thillai Nagar, Trichy, Tamil Nadu');

SELECT * FROM User;

-- creating courier table and inserting data 

CREATE TABLE Courier (
    CourierID INT PRIMARY KEY,  
    SenderName VARCHAR(255),  
    SenderAddress TEXT,  
    ReceiverName VARCHAR(255),  
    ReceiverAddress TEXT,  
    Weight DECIMAL(5,2),  
    Status VARCHAR(50),  
    TrackingNumber VARCHAR(20) UNIQUE,  
    DeliveryDate DATE
);

INSERT INTO Courier (CourierID, SenderName, SenderAddress, ReceiverName, ReceiverAddress, Weight, Status, TrackingNumber, DeliveryDate)  
VALUES  
(1, 'Arun Kumar', 'Anna Nagar, Chennai, Tamil Nadu', 'Priya Raj', 'Gandhipuram, Coimbatore, Tamil Nadu', 2.50, 'In Transit', 'TN123456789', '2025-02-15'),
(2, 'Vikram R', 'KK Nagar, Madurai, Tamil Nadu', 'Divya Shree', 'Sathyamangalam, Erode, Tamil Nadu', 1.75, 'Delivered', 'TN987654321', '2024-12-20'),
(3, 'Karthick S', 'Race Course, Trichy, Tamil Nadu', 'Meena Lakshmi', 'Kovaipudur, Coimbatore, Tamil Nadu', 3.25, 'Shipped', 'TN456789123', '2025-02-05'),
(4, 'Sundar C', 'Simmakkal, Madurai, Tamil Nadu', 'Revathi R', 'MGR Nagar, Salem, Tamil Nadu', 0.90, 'Pending', 'TN321654987', '2025-03-10'),
(5, 'Ravi Kumar', 'Gandhi Street, Vellore, Tamil Nadu', 'Anitha P', 'Thillai Nagar, Trichy, Tamil Nadu', 4.10, 'Dispatched', 'TN741852963', '2025-02-22'),
(6, 'Arun Kumar', 'Anna Nagar, Chennai, Tamil Nadu', 'Karthik S', 'Race Course, Trichy, Tamil Nadu', 2.80, 'Delivered', 'TN369258147', '2024-12-30'),
(7, 'Priya Raj', 'Gandhipuram, Coimbatore, Tamil Nadu', 'Vikram R', 'KK Nagar, Madurai, Tamil Nadu', 1.55, 'In Transit', 'TN852963741', '2025-03-18'),
(8, 'Divya Shree', 'Sathyamangalam, Erode, Tamil Nadu', 'Sundar C', 'Simmakkal, Madurai, Tamil Nadu', 3.00, 'Shipped', 'TN159357486', '2025-01-12'),
(9, 'Meena Lakshmi', 'Kovaipudur, Coimbatore, Tamil Nadu', 'Ravi Kumar', 'Gandhi Street, Vellore, Tamil Nadu', 2.40, 'Dispatched', 'TN753951486', '2025-02-25'),
(10, 'Revathi R', 'MGR Nagar, Salem, Tamil Nadu', 'Anitha P', 'Thillai Nagar, Trichy, Tamil Nadu', 1.20, 'Pending', 'TN369147258', '2024-08-08');

select * from Courier;

-- creating employee table and inserting data 

CREATE TABLE Employee (
    EmployeeID INT PRIMARY KEY,  
    Name VARCHAR(255),  
    Email VARCHAR(255) UNIQUE,  
    ContactNumber VARCHAR(20),  
    Role VARCHAR(50),  
    Salary DECIMAL(10,2)
);

INSERT INTO Employee (EmployeeID, Name, Email, ContactNumber, Role, Salary)  
VALUES  
(101, 'Arun B', 'arun156@email.com', '9876543210', 'Admin', 90000.00),
(102, 'Raj Velan K', 'raj@email.com', '9868454898', 'Courier Manager', 70000.00),
(103, 'Karthika S', 'karthika.s@email.com', '9787654787', 'Delivery Executive', 45000.00),
(104, 'Divya Shree H', 'divya.shree@email.com', '9767266767', 'Customer Support', 35000.00),
(105, 'Sundar C', 'sundar.c@email.com', '9656565656', 'Warehouse Staff', 35000.00),
(106, 'Thilak S', 'thilak@email.com', '9545454545', 'Dispatcher', 30000.00),
(107, 'Meena T', 'meena@email.com', '9434343434', 'Billing Officer', 40000.00),
(108, 'John Mathew R', 'john.r@email.com', '6323232323', 'Fleet Manager', 70000.00),
(109, 'Anitha P', 'anitha.p@email.com', '9212121212', 'Tracking Specialist', 48000.00),
(100, 'Revathi R', 'revathi.r@email.com', '9101010101', 'IT Support', 35000.00),
(111, 'Manoj K', 'manoj.k@email.com', '6323455411', 'Delivery Executive', 45000.00),
(112, 'Johnsen R', 'deepa.r@email.com', '9824132148', 'Courier Manager', 70000.00),
(113, 'Suresh B', 'suresh.b@email.com', '9725636523', 'Warehouse Staff', 35000.00),
(114, 'Latha K', 'neha.k@email.com', '9662657526', 'Billing Officer', 40000.00),
(115, 'Rajesh P', 'rajesh.p@email.com', '9598564545', 'Customer Support', 35000.00),
(116, 'Naveen T', 'naveen.t@email.com', '9447952656', 'Delivery Executive', 45000.00),
(117, 'Shruti L', 'shruti.l@email.com', '6331545153', 'Admin', 90000.00),
(118, 'Gokul V', 'gokul.v@email.com', '9298754545', 'Fleet Manager', 70000.00),
(119, 'Monika S', 'monika.s@email.com', '9136456485', 'Dispatcher', 30000.00),
(120, 'Harish K', 'harish.k@email.com', '9006484541', 'IT Support', 35000.00),
(121, 'Vidhya B', 'vidhya.b@email.com', '9898767654', 'Warehouse Staff', 35000.00),
(122, 'Santosh R', 'santosh.r@email.com', '9765432109', 'Customer Support', 35000.00),
(123, 'Vikash K', 'vikash.k@email.com', '9654321098', 'Tracking Specialist', 48000.00),
(124, 'Kamal P', 'komal.p@email.com', '9543210987', 'Delivery Executive', 45000.00),
(125, 'Ramesh V', 'ramesh.v@email.com', '9432109876', 'Billing Officer', 40000.00);

select * from employee;


-- creating service table and inserting data 

CREATE TABLE Service (
    ServiceID VARCHAR(10) PRIMARY KEY,  
    ServiceName VARCHAR(100),  
    Cost DECIMAL(8,2)
);

INSERT INTO Service (ServiceID, ServiceName, Cost)  
VALUES  
('S01', 'Standard Courier Delivery', 150.00),
('S02', 'Express Courier Delivery', 250.00),
('S03', 'Same-Day Delivery', 500.00),
('S04', 'International Shipping', 3000.00),
('S05', 'Package Insurance', 300.00),
('S06', 'Bulk Shipment', 750.00),
('S07', 'Document Delivery', 100.00),
('S08', 'Heavy Parcel Delivery', 1200.00),
('S09', 'Temperature Controlled Delivery', 1800.00),
('S10', 'Premium Doorstep Pickup', 350.00),
('S11', 'Overnight Shipping', 600.00),
('S12', 'Return Service', 200.00),
('S13', 'Cash on Delivery (COD)', 50.00),
('S14', 'Fragile Item Handling', 900.00),
('S15', 'Subscription-Based Courier', 3200.00);

select * from Service;


-- creating location table and inserting data 

CREATE TABLE Location (
    LocationID INT PRIMARY KEY,  
    LocationName VARCHAR(100),  
    Address TEXT
);

INSERT INTO Location (LocationID, LocationName, Address)  
VALUES  
(1, 'Chennai Central Hub', '123, Anna Salai, Chennai, Tamil Nadu - 600002'),
(2, 'Coimbatore Warehouse', '45, Avinashi Road, Coimbatore, Tamil Nadu - 641018'),
(3, 'Madurai Dispatch Center', '78, KK Nagar, Madurai, Tamil Nadu - 625020'),
(4, 'Trichy Main Office', '56, Rockfort Street, Tiruchirappalli, Tamil Nadu - 620001'),
(5, 'Salem Distribution Center', '34, Gandhi Road, Salem, Tamil Nadu - 636007'),
(6, 'Tirunelveli Branch', '23, VOC Nagar, Tirunelveli, Tamil Nadu - 627002'),
(7, 'Erode Courier Office', '67, Perundurai Road, Erode, Tamil Nadu - 638011'),
(8, 'Vellore Parcel Hub', '89, Katpadi Road, Vellore, Tamil Nadu - 632007'),
(9, 'Thanjavur Logistics', '12, South Main Street, Thanjavur, Tamil Nadu - 613001'),
(10, 'Kanyakumari Regional Center', '90, Beach Road, Kanyakumari, Tamil Nadu - 629702');

select * from Location;


-- creating payment table and inserting data 

CREATE TABLE Payment (
    PaymentID INT PRIMARY KEY,  
    CourierID INT,  
    LocationID INT,  
    UserID INT,
    ServiceID VARCHAR(10),
    Amount DECIMAL(10, 2),  
    PaymentDate DATE,
    FOREIGN KEY (UserID) REFERENCES User(UserID),
    FOREIGN KEY (ServiceID) REFERENCES Service(ServiceID),
    FOREIGN KEY (CourierID) REFERENCES Courier(CourierID),  
    FOREIGN KEY service(LocationID) REFERENCES Location(LocationID)
);

INSERT INTO Payment(PaymentID,CourierID,LocationID,UserID,ServiceID,Amount,PaymentDate)
VALUES
(501, 1, 1,1001,'S01', 150.00, '2025-01-12'),
(502, 2, 2,1002,'S02',200.00, '2025-02-20'),
(503, 3, 3,1003,'S03', 150.00, '2025-02-25'),
(504, 4, 4,1004,'S04', 3000.00, '2025-03-06'),
(508, 8, 8,1005,'S05', 3200.00, '2024-12-09');

select * from payment;
