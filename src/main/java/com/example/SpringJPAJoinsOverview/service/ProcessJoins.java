package com.example.SpringJPAJoinsOverview.service;

import com.example.SpringJPAJoinsOverview.entity.Department;
import com.example.SpringJPAJoinsOverview.entity.Employee;
import com.example.SpringJPAJoinsOverview.entity.Phone;
import com.example.SpringJPAJoinsOverview.jpaRepo.DepartmentRepo;
import com.example.SpringJPAJoinsOverview.jpaRepo.EmployeeAndDepartmentRepo;
import com.example.SpringJPAJoinsOverview.jpaRepo.EmployeeRepo;
import com.example.SpringJPAJoinsOverview.jpaRepo.PhoneRepo;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ProcessJoins {

    private final EmployeeRepo employeeRepo;

    private final DepartmentRepo departmentRepo;

    private final PhoneRepo phoneRepo;

    public ProcessJoins(EmployeeRepo employeeRepo, DepartmentRepo departmentRepo, PhoneRepo phoneRepo) {
        this.employeeRepo = employeeRepo;
        this.departmentRepo = departmentRepo;
        this.phoneRepo = phoneRepo;

    }

    public void processData() {

        // find all employees in a department
        List<Employee> employee = employeeRepo.findAllEmployeesByDepartmentId(1);
        System.out.println("All employees in department 1:"+employee);

        // find department of employee
        Department department = departmentRepo.findDepartmentByEmployeeId(1);
        System.out.println("Department of employee 1:"+department);

        // get aged person in a department
        Employee employee1 = employeeRepo.findTopByOrderByAgeDesc(); // in built query
        System.out.println("Older employee:"+employee1);

        // get employee by name
        Employee empDetail = employeeRepo.findByName("Ram");
        System.out.println("Fetched employee:"+empDetail.getName());

        // get all phones number of Employee
        Phone empPhone = phoneRepo.findAllPhoneByEmployee(3);
        System.out.println("Phone number of employee 3:"+empPhone.getNumber());

        // Employee with highest salary
        List<Employee> employee2 = employeeRepo.findTopByDepartmentDeptIdOrderBySalaryDesc(1);
        System.out.println("Employee with highest salary in Department 1:"+employee2.get(0));

        // get first 3 employee with same name when sorted by name
        Sort sort = Sort.by(Sort.Direction.ASC,"name");
        List<Employee> first3ByName = employeeRepo.findFirst3ByName("Joey",sort);
        System.out.println("first 3 employees with same name when sorted in ascending order :"+first3ByName);

        // To fetch employees and their department details
        List<EmployeeAndDepartmentRepo> employeeAndDept = employeeRepo.findAllEmployeeAndDepartment();
        employeeAndDept
                .forEach(e ->
                        System.out.println(
                                e.getEmpId() + " | " +
                                e.getAge() + " | " +
                                e.getSalary() + " | " +
                                e.getEmpName() + " | " +
                                e.getDeptName() + " | " +
                                e.getEmpDeptID() + " | " +
                                e.getDeptDeptID()
                        )
                );
    }
}
