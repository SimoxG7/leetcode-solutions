select t.name as 'Employee'
from Employee as t
where t.salary > (
  select t1.salary 
  from Employee as t1 
  where t1.id = t.managerId
)