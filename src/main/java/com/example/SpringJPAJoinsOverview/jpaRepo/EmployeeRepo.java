package com.example.SpringJPAJoinsOverview.jpaRepo;

import com.example.SpringJPAJoinsOverview.entity.Employee;
import com.example.SpringJPAJoinsOverview.entity.EmployeeAndDepartment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    // to get all employees in a department
    @Query("SELECT e FROM Employee e JOIN e.department d where d.id= ?1") // working
    public List<Employee> findEmployeeByDepartment(Long deptId);

    // find older employee
    @Query(value = "select top 1 * from Employee e order by age desc",nativeQuery = true)
    public Employee findEmployeeByAge();

    // get highest salary of employees in a department
    @Query(value = "select e.salary from Employee e JOIN e.department d where d.id =?1 order by salary desc ")
    public List<Long> findTopSalaryOfEmployeeByDepartment(Long id);

    List<Employee> findFirst3ByName(String name, Sort sort);

    // Note: Here alias is important. Each are corresponding to field names in EmployeeAndDepartmentRepo interface. Changing will result in null values in result
    @Query(value = "select e.emp_id as empId, e.age, e.name as empName, e.salary, d.name as DeptName, d.dept_id as empDeptID, e.department_dept_id as deptDeptID" +
            " from Employee e inner join Department d on d.dept_id = e.department_dept_id", nativeQuery = true)
    public List<EmployeeAndDepartmentRepo> findAllEmployeeAndDepartment();

}
