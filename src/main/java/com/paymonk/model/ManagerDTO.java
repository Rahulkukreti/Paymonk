package com.paymonk.model;

import com.paymonk.domain.Manager;

public class ManagerDTO {

    private Long id;
    private String department;
    private Float salary;
    private String address;
    public ManagerDTO( Long id,String department, Float salary, String address) {
        this.id = id;
        this.department = department;
        this.salary = salary;
        this.address = address;
    }
    public ManagerDTO() {
    }

    public ManagerDTO(Manager manager) {

        this.address = manager.getAddress();
        this.department = manager.getDepartment();
        this.salary = manager.getSalary();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
