package com.example.SpringJPAJoinsOverview.jpaRepo;

import com.example.SpringJPAJoinsOverview.entity.Department;
import com.example.SpringJPAJoinsOverview.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepo extends JpaRepository<Department,Integer> {

    @Query("select d from Department d join d.employees e where e.id = ?1")
    public Department findAllEmployeesByDepartment(Long id);


}
