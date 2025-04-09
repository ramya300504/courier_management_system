-- Table creation

create table customer (
    customer_id int primary key,
    name varchar(100) not null,
    email_address varchar(100) unique ,
    phone_number varchar(15) not null,
    address varchar(200),
    credit_score int
);

-- Sample data insertion

INSERT INTO customer (customer_id, name, email_address, phone_number, address, credit_score)
VALUES 
(1, 'Aarthi', 'aarthi.johnson@example.com', '9876543210', '123 Main Street, CityA', 700),
(2, 'Smith', 'bob.smith@example.com', '9123456789', '456 Park Avenue, CityB', 620),
(3, 'Ramya', 'ramya.@example.com', '9876543210', '143 Main Street, CityA', 340);

select * from customer;

-- Table creation

create table loan (
    loan_id int primary key,
    customer_id int not null,
    principal_amount decimal(15, 2) not null,
    interest_rate decimal(4, 2) not null,
    loan_term int not null,
    loan_type varchar(50), 
    loan_status varchar(50) ,
    foreign key (customer_id) references customer(customer_id)
    on delete cascade
);

-- sample data inertion

INSERT INTO loan (loan_id, customer_id, principal_amount, interest_rate, loan_term, loan_type, loan_status)
VALUES (101, 1, 500000.00, 8.50, 24, 'Home Loan', 'Pending'), 
(108, 2, 500000.00, 8.50, 24, 'Home Loan', 'Pending');
select * from loan;
