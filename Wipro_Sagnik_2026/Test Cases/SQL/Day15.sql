create database wipro_trainning;
use wipro_trainning;
show tables;


create table employees2 (emp_id int PRIMARY KEY, emp_name varchar(50), department varchar(50), salary decimal(10,2), email varchar(30), joinning_date DATE);

SET SQL_SAFE_UPDATES = 0;

insert into employees2
values(101,'Sagnik Hore','IT',25000,'sagnikhore@gmail.com','2026-06-22'),
(102,'Arpan Jana','IT',25000,'arpjana@gmail.com','2026-06-22'),
(103,'Aniket Talukdar','Software Testing',25000,'aniketalukdar@gmail.com','2026-06-22'),
(104,'Sharyua Chatterjee','Software Testing',25000,'sha256@gmail.com','2026-06-22'),
(105,'Arka Das', 'Software Testing',25000,'arkad001@gmail.com','2026-06-22'),
(106,'Gaurav Kumar','IT',25000,'Gaurav203@gmail.com','2026-06-22'),
(107,'Ram Babu','IT',25000,'rambabu@gmail.com','2026-06-22');

insert into employees2 values
(108,'Ram Babu','SDET',25000,'rambabu@gmail.com','2026-06-22'),
(109,'Ram Charan','SDET',25000,'rambabu@gmail.com','2026-06-22');

select * from employees2 where department ="IT";

Update employees2
set salary = (salary+5000 ) 
where department = "Software Testing";

update employees2 
set salary = 50000
where emp_id = 101;

delete from employees2 where emp_id = 107;

select * from employees2 order by salary desc;

select * from employees2 order by salary desc limit 2;

select count(*) as total_employees from employees2;

select avg(salary) as avg_salary from employees2;

select max(salary) as Highest_Salary,
min(salary) as Lowest_Salary from employees2;

select department, COUNT(*) as department_count
from employees2
group by department;

select department, COUNT(*) as employee_count
from employees2
group by department
having COUNT(*) > 1;

insert into employees2 values (110,'Vijay','SDET',25000,null,'2026-06-22');



select * from employees2 where email is null;

select * from employees2 where emp_name like 'R%';

select * from employees2 where salary between 40000 and 60000;


insert into employees2 values (111,'Salmon','HR',25000,'salmon@gmail.com','2026-06-22');


select * from employees2 where department in ('HR' ,'IT');

ALTER TABLE employees2
add mobile_number VARCHAR(15);

alter table employees2
rename column emp_name to employee_name;

alter table employees2
drop column mobile_number;



select * from employees2;

alter table employees2
add column department_id int;

update employees2
set department_id = 1 
where department = "IT";

update employees2
set department_id = 2
where department = "Software Testing";

update employees2
set department_id = 3
where department = "SDET";


update employees2
set department_id = 4
where department = "HR";

create table department(department_id int primary key, dept_manager varchar(20));

insert into department values (1 ,"Harshit"),
(2, "Sunil"),
(3, "Varun"),
(4, "Vaibhav");

select * from department;


select e.employee_name, e.department, d.dept_manager
from employees2 e 
join department d
on e.department_id =d.department_id;

SELECT e.employee_name , e.department, d.dept_manager
FROM employees2 e, department d
WHERE e.department_id = d.department_id;

select * from employees2
where salary >(select avg(salary) from employees2);

select email, count(*) as duplicate_email_count
from employees2 
group by email
having count(*) > 1;

SELECT *
FROM employees2
WHERE EMP_id = 101
AND employee_name = 'Sagnik Hore'
AND department = 'IT';

delete from employees2
where email is null;

CREATE TABLE employees_backup AS
SELECT *
FROM employees2;

select * from employees_backup;


