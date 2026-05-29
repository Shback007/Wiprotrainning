create database Ecommerce;

use Ecommerce;

create table Customers(
	customer_id int primary key,
    customer_name varchar(50),
    city varchar(50)
    );
    
    create table Orders (
    order_id int primary key,
    customer_id int,
    product_id int,
    order_amount int
    );
    
    create table Payments (
    payment_id int primary key,
    order_id int,
    payment_mode varchar(50),
    payment_status varchar(50)
    );
    
    create table Products(
    product_id int primary key,
    product_name varchar(50),
    price int
    );
    
    insert into Customers values 
    (1, 'Rahul' ,'Delhi'),
    (2, 'Aniket', 'Siliguri'),
    (3, 'Sagnik' ,'Dinhata'),
    (4, 'Arpan' ,'Kolkata');
	insert into Customers values 
    (5, 'Aman' ,'Delhi');
    
    insert into Products values 
    (101,'Laptop',70000),
    (102,'Mobile',25000),
    (103,'Headphones',3000);
    
    insert into Orders values
    (1001,1,101,70000),
    (1002,2,102,25000),
    (1003,1,103,3000),
    (1004,5,101,70000);
    
    insert into Payments values
    (1,1001,'UPI','Success'),
    (2,1002,'Card','Success'),
    (3,1005,'Cash','Pending');
    
    -- Inner Join
    select c.customer_name, o.order_id,o.order_amount
    from Customers c
    Inner join orders o
    on c.customer_id = o.customer_id;
    
    -- Left Join
    select c.customer_name, o.order_id
    from Customers c
    left join Orders o
    on c.customer_id = o.customer_id;
    
    -- Right Join
	select c.customer_name, o.order_id
    from Customers c
    right join Orders o
    on c.customer_id = o.customer_id;
    
    -- Full Outer Join
    select c.customer_name,o.order_id
    from Customers c
    left join Orders o
    on c.customer_id = o.customer_id
    union
    select c.customer_name, o.order_id
    from Customers c
    right join Orders o
    on c.customer_id = o.customer_id;
    
    -- Cross Join
    select c.customer_name, p.product_name
    from Customers c 
    cross join Products p;
    
    -- Self Join
    select 
    A.customer_name as Customer1,
    B.customer_name as Customer2,
    A.city
    from Customers A, Customers B
    where A.customer_id <> B.customer_id
    and A.city = B.city;
    
    -- Natural Join
    select * from Orders
    natural join Customers;
    
    -- ALl joins Combined
    select 
    c.customer_name,
    p.product_name,
    o.order_amount,
    pay.payment_status
    from Customers c
    join Orders o
    on c.customer_id = o.customer_id
    join Products p
    on o.product_id = p.product_id
    join Payments pay
    on o.order_id = pay.order_id;
    
    
    

