package com.example.SpringJPAJoinsOverview.jpaRepo;

import com.example.SpringJPAJoinsOverview.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PhoneRepo extends JpaRepository<Phone, Integer> {

    @Query("SELECT e.phone  FROM Employee e   WHERE e.empId = ?1")
    Phone findAllPhoneByEmployee(Integer empId);

}