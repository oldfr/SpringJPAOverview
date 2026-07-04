package com.example.SpringJPAJoinsOverview.jpaRepo;

import com.example.SpringJPAJoinsOverview.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {

    @Query("SELECT d  FROM Department d  JOIN d.employees e   WHERE e.empId = ?1 ")
    Department findDepartmentByEmployeeId(Integer empId);

}