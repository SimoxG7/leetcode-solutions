select 
  D.name as 'Department',
  E.name as 'Employee',
  E.salary as 'Salary'
from Employee as E
join Department as D 
on D.id = E.departmentId 
where E.salary = (
  select max(E1.salary)
  from Employee as E1
  where E1.departmentId = E.departmentId 
)