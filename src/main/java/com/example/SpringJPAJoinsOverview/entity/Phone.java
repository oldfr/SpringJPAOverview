package com.example.SpringJPAJoinsOverview.entity;

import javax.persistence.*;

@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long phone_id;

    private String number;

    @ManyToOne//(targetEntity = Phone.class)
//    @JoinColumn(name = "phone_id", insertable = false, updatable = false) // throws error
    private Employee employee;

    public Phone() {
    }

    public Phone(String number) {
        this.number = number;
    }

    public long getPhone_id() {
        return phone_id;
    }

    public void setPhone_id(long phone_id) {
        this.phone_id = phone_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + phone_id +
                ", number='" + number + '\'' +
                '}';
    }
}
