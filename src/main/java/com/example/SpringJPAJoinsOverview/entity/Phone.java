package com.example.SpringJPAJoinsOverview.entity;
//import jakarta.persistence.*;

import javax.persistence.*;

@Entity
@Table(name = "PHONE")
public class Phone {

    @Id
    @Column(name = "phone_id")
    private Integer phoneId;

    @Column(name = "number", nullable = false)
    private String number;

    public Phone() {
    }

    public Phone(Integer phoneId, String number) {
        this.phoneId = phoneId;
        this.number = number;
    }

    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phoneId=" + phoneId +
                ", number='" + number + '\'' +
                '}';
    }
}
