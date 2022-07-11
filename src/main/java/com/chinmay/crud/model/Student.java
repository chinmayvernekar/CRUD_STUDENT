package com.chinmay.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private UUID id;

    private String firstName;
    private String lastName;
    private String address;
    private Integer standrad;
    private Integer rollNo;
    private String divison;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStandrad() {
        return standrad;
    }

    public void setStandrad(Integer standrad) {
        this.standrad = standrad;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public String getDivison() {
        return divison;
    }

    public void setDivison(String divison) {
        this.divison = divison;
    }
}
