package com.example.SpringJPAJoinsOverview.jpaRepo;

// represents the view of the query result when employee and their department details are fetched
public interface EmployeeAndDepartmentProjection {
    Long getEmpId();
    Integer getAge();
    Integer getSalary();
    String getEmpName();
    String getDeptName();
    Integer getEmpDeptID();
    Integer getDeptDeptID();
}
