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
    List<Employee> findTopByDepartmentDeptIdOrderBySalaryDesc(Integer deptId);

    // First 3 employees having same name
    List<Employee> findFirst3ByName(String name, Sort sort);


    // Employee + Department projection NOTE: Below is using JPQL i.e, query using field names instead of column names
    @Query(" SELECT    e.empId AS empId, e.age AS age,    e.name AS empName,  e.salary AS salary, d.name AS deptName,  e.department.deptId AS empDeptID, d.deptId AS deptDeptID FROM Employee e JOIN e.department d")
    List<EmployeeAndDepartmentRepo> findAllEmployeeAndDepartment();

}