package com.example.SpringJPAJoinsOverview.jpaRepo;

import com.example.SpringJPAJoinsOverview.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    // to get all employees in a department
    @Query("SELECT e FROM Employee e JOIN e.department d where d.id= ?1") // working
    public List<Employee> findEmployeeByDepartment(Long deptId);

    @Query(value = "select top 1 * from Employee e order by age desc",nativeQuery = true)
    public Employee findEmployeeByAge();

    @Query(value = "select e.salary from Employee e JOIN e.department d where d.id =?1 order by salary desc ")
    public List<Long> findTopSalaryOfEmployeeByDepartment(Long id);
}
