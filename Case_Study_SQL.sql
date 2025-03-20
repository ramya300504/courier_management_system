use asset_management;

-- creating employees table and inserting records

CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(50),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(255)
);

INSERT INTO employees (employee_id, name, department, email, password) VALUES
(101, 'Arun Kumar', 'Asset Procurement', 'arun.kumar@tamilnadu.com', 'Arun@123'),
(102, 'Priya Raj', 'Asset Tracking', 'priya.raj@tamilnadu.com', 'Priya@123'),
(103, 'Vikram Anand', 'Inventory Management', 'vikram.anand@tamilnadu.com', 'Vikram@123'),
(104, 'Divya Suresh', 'Asset Maintenance', 'divya.suresh@tamilnadu.com', 'Divya@123'),
(105, 'Karthik Raja', 'Asset Disposal', 'karthik.raja@tamilnadu.com', 'Karthik@123'),
(106, 'Meena Devi', 'Asset Compliance', 'meena.devi@tamilnadu.com', 'Meena@123'),
(107, 'Suresh Babu', 'Asset Procurement', 'suresh.babu@tamilnadu.com', 'Suresh@123'),
(108, 'Lakshmi Narayanan', 'Inventory Management', 'lakshmi.narayanan@tamilnadu.com', 'Lakshmi@123'),
(109, 'Balaji Krishnan', 'Asset Maintenance', 'balaji.krishnan@tamilnadu.com', 'Balaji@123'),
(110, 'Anitha Raman', 'Asset Disposal', 'anitha.raman@tamilnadu.com', 'Anitha@123');
select * from employees;

-- creating assets table and inserting records

CREATE TABLE assets (
    asset_id INT PRIMARY KEY,
    name VARCHAR(100),
    type VARCHAR(50),
    serial_number VARCHAR(20) UNIQUE,
    purchase_date DATE,
    location VARCHAR(100),
    status VARCHAR(50),
    owner_id INT,
    FOREIGN KEY (owner_id) REFERENCES employees(employee_id)
);

INSERT INTO assets (asset_id, name, type, serial_number, purchase_date, location, status, owner_id) VALUES
(1, 'Dell Latitude 5430', 'Laptop', 'S01001', '2024-12-05', 'Chennai Office', 'In Use', 101),
(2, 'Toyota Innova', 'Vehicle', 'S01002', '2024-12-10', 'Coimbatore Branch', 'In Use', 102),
(3, 'HP LaserJet Pro', 'Printer', 'S01003', '2025-01-03', 'Madurai Office', 'Under Maintenance', 103),
(4, 'Cisco Router', 'Networking Equipment', 'S01004', '2025-01-15', 'Chennai Data Center', 'In Use', 104),
(5, 'Apple MacBook Air', 'Laptop', 'S01005', '2025-01-25', 'Trichy Office', 'In Use',105),
(6, 'Honda Activa', 'Vehicle', 'S01006', '2025-02-05', 'Salem Branch', 'Decommissioned', 106),
(7, 'Samsung 55-inch TV', 'Display', 'S01007', '2025-02-18', 'Chennai Conference Room', 'In Use', 107),
(8, 'Lenovo ThinkPad X1', 'Laptop', 'S01008', '2025-03-01', 'Madurai IT Room', 'In Use', 108),
(9, 'Canon Scanner', 'Scanner', 'S01009', '2025-03-10', 'Coimbatore Office', 'Under Maintenance', 109),
(10, 'Yamaha Fascino', 'Vehicle', 'S01010', '2025-03-15', 'Chennai Parking', 'In Use', 110),
(11, 'Dell PowerEdge R740', 'Server', 'S01011', '2025-01-10', 'Chennai Data Center', 'In Use', 109),
(12, 'Epson EcoTank L3250', 'Printer', 'S01012', '2025-02-20', 'Coimbatore Office', 'In Use', 102),
(13, 'Hyundai Creta', 'Vehicle', 'S01013', '2025-02-28', 'Madurai Branch', 'In Use', 103),
(14, 'Sony Bravia 65-inch', 'Display', 'S01014', '2025-03-05', 'Trichy Conference Room', 'In Use', 102);

select * from assets;

--  creating maintenance_records table and inserting records
 
CREATE TABLE maintenance_records 
(
    maintenance_id INT PRIMARY KEY,
    asset_id INT,
    maintenance_date DATE,
    description VARCHAR(255),
    cost DECIMAL(10,2),
    FOREIGN KEY (asset_id) REFERENCES assets(asset_id)
);

INSERT INTO maintenance_records (maintenance_id, asset_id, maintenance_date, description, cost) VALUES
(51, 1, '2024-12-10', 'Routine system check and software update', 1200.00),
(52, 2, '2024-12-18', 'Engine oil change and tire rotation', 2500.00),
(83, 3, '2025-01-07', 'Toner replacement and printhead cleaning', 1500.00),
(74, 4, '2025-01-22', 'Firmware update and security patch installation', 1000.00),
(55, 5, '2025-02-3', 'Battery health check and keyboard replacement', 1800.00),
(62, 6, '2025-02-10', 'Brake pad replacement and general servicing', 3000.00),
(77, 7, '2025-02-28', 'Screen calibration and software update', 800.00),
(89, 8, '2025-03-11', 'SSD upgrade and RAM expansion', 2500.00),
(49, 9, '2025-03-19', 'Scanner lens cleaning and driver update', 1200.00),
(18, 10, '2025-03-28', 'Oil change and engine tuning', 3500.00),
(17, 11, '2025-01-24', 'Server cooling system maintenance and backup check', 5000.00),
(50, 12, '2025-02-26', 'Printer nozzle cleaning and ink refill', 1300.00),
(39, 13, '2025-03-10', 'Vehicle suspension check and alignment', 2800.00),
(45, 14, '2025-03-14', 'Display panel inspection and brightness adjustment', 900.00);

-- creating asset_allocations table and inserting records:

CREATE TABLE asset_allocations (
    allocation_id INT PRIMARY KEY,
    asset_id INT,
    employee_id INT,
    allocation_date DATE,
    return_date DATE,
    FOREIGN KEY (asset_id) REFERENCES assets(asset_id),
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
); 
INSERT INTO asset_allocations (asset_id,allocation_id,employee_id, allocation_date, return_date) VALUES
(1, 201, 101, '2024-12-15', '2024-02-15'),
(2, 202, 102, '2024-12-25', NULL),
(3, 203, 103, '2025-01-12', '2024-03-01'),
(4, 804, 104, '2025-01-20', NULL),
(5, 605, 105, '2025-02-15', '2024-03-30'),
(11, 406, 106, '2025-01-25', '2024-02-15'),
(7, 507, 107, '2025-02-27', NULL),
(14, 208, 108, '2025-03-18', '2024-04-10'),
(9, 809, 109, '2025-03-21', NULL),
(10, 210, 110, '2025-03-12', '2025-04-05');

-- creating reservations table (to store order details) and inserting records

CREATE TABLE reservations (
    reservation_id INT PRIMARY KEY,
    asset_id INT,
    employee_id INT,
    reservation_date DATE,
    start_date DATE,
    end_date DATE,
    status VARCHAR(20),
    FOREIGN KEY (asset_id) REFERENCES assets(asset_id),
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);

INSERT INTO reservations ( asset_id, employee_id,reservation_id, reservation_date, start_date, end_date, status) VALUES
(2, 102, 1002, '2024-12-15', '2024-12-28', '2025-01-10', 'approved'),
(3, 103, 1003, '2025-01-06', '2025-01-14', '2025-01-30', 'pending'),
(4, 104, 1004, '2025-01-12', '2025-01-23', '2025-02-15', 'approved'),
(9, 109, 1009, '2025-03-11', '2025-03-25', '2025-03-29', 'canceled'),
(14, 108, 1008, '2025-03-08', '2025-03-22', '2025-04-08', 'approved'),
(5, 105, 1005, '2025-02-09', '2025-02-19', '2025-03-10', 'pending'),
(11, 106, 1006, '2025-01-19', '2025-01-27', '2025-02-12', 'approved');