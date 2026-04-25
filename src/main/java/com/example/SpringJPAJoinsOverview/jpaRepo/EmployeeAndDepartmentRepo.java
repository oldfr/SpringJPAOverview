package com.example.SpringJPAJoinsOverview.jpaRepo;


public interface EmployeeAndDepartmentRepo {
    Long getEmpId();
    Integer getAge();
    Integer getSalary();
    String getEmpName();
    String getDeptName();
    Integer getEmpDeptID();
    Integer getDeptDeptID();


}
/*
import com.example.SpringJPAJoinsOverview.entity.EmployeeAndDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
*/

// not working
/*
@Repository
public interface EmploeeAndDepartmentRepo extends JpaRepository<EmployeeAndDepartment, BigInteger> {

    @Query(value = "select e.emp_id, e.age, e.name as EName, e.salary, d.Name as DeptName, d.dept_id, e.department_dept_id" +
            " from Employee e join Department d on d.dept_id = e.department_dept_id", nativeQuery = true)
    public List<EmployeeAndDepartment> findAllEmployeeAndDepartment();

}*/
