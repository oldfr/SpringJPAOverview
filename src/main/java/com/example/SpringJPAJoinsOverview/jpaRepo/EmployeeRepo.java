package com.example.SpringJPAJoinsOverview.jpaRepo;

import com.example.SpringJPAJoinsOverview.entity.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    // All employees of a department
    @Query("SELECT e FROM Employee e WHERE e.department.deptId = ?1")
    List<Employee> findAllEmployeesByDepartmentId(Integer deptId);


    // Oldest employee
    Employee findTopByOrderByAgeDesc();


    // Employee by name
    Employee findByName(String name);


    // Highest salary in department
    @Query("SELECT e.salary FROM Employee e WHERE e.department.deptId = ?1 ORDER BY e.salary DESC")
    List<Long> findTopSalaryOfEmployeeByDepartment(Long deptId);


    // First 3 employees having same name
    List<Employee> findFirst3ByName(String name, Sort sort);


    // Employee + Department projection
    @Query(value = "SELECT   e.emp_id AS empId,  e.age AS age,   e.name AS empName, e.salary AS salary, d.name AS deptName, e.department_dept_id AS empDeptID,  d.dept_id AS deptDeptID FROM employee e  INNER JOIN department d   ON e.department_dept_id = d.dept_id",           nativeQuery = true)
    List<EmployeeAndDepartmentRepo> findAllEmployeeAndDepartment();

}