package com.paymonk.model;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class ManagerCO {

    @NotBlank
    @Column(name = "department")
    private String department;


    @Column(name = "Salary")
    private Float salary;


    @NotBlank
    @Column(name = "Address")
    private String address;

    private EmployeeCO employeeCO;

    public EmployeeCO getEmployeeCO() {
        return employeeCO;
    }

    public void setEmployeeCO(EmployeeCO employeeCO) {
        this.employeeCO = employeeCO;
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
