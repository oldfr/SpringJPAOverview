package com.example.SpringJPAJoinsOverview.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int age;

    @ManyToOne//(targetEntity = Department.class)
    private Department department;

    @OneToMany(mappedBy = "employee")
    private List<Phone> phones;

    public Employee() {
    }

    public Employee(String name, int age, Department department, List<Phone> phones) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.phones = phones;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", department=" + department +
                ", phones=" + phones +
                '}';
    }
}
