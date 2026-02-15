package com.example.SpringJPAJoinsOverview.service;

import com.example.SpringJPAJoinsOverview.entity.Department;
import com.example.SpringJPAJoinsOverview.entity.Employee;
import com.example.SpringJPAJoinsOverview.entity.EmployeeAndDepartment;
import com.example.SpringJPAJoinsOverview.entity.Phone;
import com.example.SpringJPAJoinsOverview.jpaRepo.DepartmentRepo;
//import com.example.SpringJPAJoinsOverview.jpaRepo.EmploeeAndDepartmentRepo;
import com.example.SpringJPAJoinsOverview.jpaRepo.EmployeeRepo;
import com.example.SpringJPAJoinsOverview.jpaRepo.PhoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Component
@Transactional
public class ProcessJoins {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private PhoneRepo phoneRepo;
/*
    @Autowired
    private EmploeeAndDepartmentRepo emploeeAndDepartmentRepo;*/

    public void loadDataInTables() {
        Phone ph1 = new Phone("1256624789");
        Phone ph2 = new Phone("1256624789");
        Phone ph3 = new Phone("1256624789");
        Phone ph4 = new Phone("1256624789");
        Phone ph5 = new Phone("1256624789");
        Phone ph6 = new Phone("1256624789");

        List<Phone> phoneNumOfEmp1 = Arrays.asList(ph1,ph2);
        List<Phone> phoneNumOfEmp2 = Arrays.asList(ph3,ph4);
        List<Phone> phoneNumOfEmp3 = Arrays.asList(ph5,ph6);


        Department department1 = new Department("IT");
        Employee emp1 = new Employee("Ankitha",27,department1,100L,phoneNumOfEmp1);
        Employee emp2 = new Employee("Adithya",25,department1,800L,phoneNumOfEmp2);
        Employee emp3 = new Employee("Ramanna",37,department1,900L,phoneNumOfEmp3);

        Department department2 = new Department("HR");
//        Employee emp21 = new Employee("Vinay",27,department2,1000L,phoneNumOfEmp1);
        Employee emp21 = new Employee("Joey",27,department2,1000L,phoneNumOfEmp1);
//        Employee emp22 = new Employee("Vidhya",25,department2,1200L,phoneNumOfEmp2);
        Employee emp22 = new Employee("Joey",25,department2,1200L,phoneNumOfEmp2);
        Employee emp23 = new Employee("Archana",37,department2,400L,phoneNumOfEmp3);

        departmentRepo.save(department1);
        departmentRepo.save(department2);

        List<Employee> employees1 = Arrays.asList(emp1,emp2,emp3);
        List<Employee> employees2 = Arrays.asList(emp21,emp22,emp23);

        employeeRepo.saveAll(employees1);
        employeeRepo.saveAll(employees2);

        ph1.setEmployee(emp1);
        ph2.setEmployee(emp1);
        ph3.setEmployee(emp2);
        ph4.setEmployee(emp2);
        ph5.setEmployee(emp3);
        ph6.setEmployee(emp3);

        phoneRepo.saveAll(Arrays.asList(ph1,ph2,ph3,ph4,ph5,ph6));

        // find all employees in a department
        List<Employee> employee = employeeRepo.findEmployeeByDepartment(1L);
        System.out.println("All employees in department 1:"+employee);

        // find department of employee
        Department department = departmentRepo.findAllEmployeesByDepartment(1L);
        System.out.println("Department of employee 1:"+department);

        // get aged person in a department
        Employee employee1 = employeeRepo.findEmployeeByAge();
        System.out.println("Older employee:"+employee1);

        // get all phones number of Employee
        List<Phone> phones = phoneRepo.findAllPhonesByEmployee(3L);
        System.out.println("Phone numbers of employee 3:"+phones);

        // Employee with highest salary
        List<Long> employee2 = employeeRepo.findTopSalaryOfEmployeeByDepartment(1L);
        System.out.println("Employee with highest salary in Department1:"+employee2.get(0));

        // get first 3 employee with same name when sorted by name
        Sort sort = Sort.by(Sort.Direction.ASC,"name");
        List<Employee> first3ByName = employeeRepo.findFirst3ByName("Joey",sort);
        System.out.println("first 3 employees with same name when sorted in ascending order :"+first3ByName);
/*
        List<EmployeeAndDepartment> employeeAndDept = employeeRepo.findAllEmployeeAndDepartment();
        System.out.prinval:tln("employeeAndDept: "+employeeAndDept);*/

    }

}
