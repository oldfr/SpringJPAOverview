package com.example.SpringJPAJoinsOverview.jpaRepo;

import com.example.SpringJPAJoinsOverview.entity.Employee;
import com.example.SpringJPAJoinsOverview.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhoneRepo extends JpaRepository<Phone,Integer> {

    @Query(value = "select p from Employee e join e.phones p where e.id =?1")
    public List<Phone> findAllPhonesByEmployee(Long id);
}
