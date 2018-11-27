package com.paymonk.model;

import com.paymonk.domain.Employee;

public class EmployeeDTO {

    private Long id;
    private String employeeId;
    private String name;
    private String experties;
    private String designation;


    public EmployeeDTO(){}

    public EmployeeDTO(Employee emp){
        this.id = emp.getId();
        this.employeeId = emp.getEmployeeId();
        this.name= emp.getName();
        this.experties = emp.getExperties();
        this.designation = emp.getDesignation();
    }

    public EmployeeDTO(Long id, String employeeId, String name, String experties, String designation) {
        this.id = id;
        this.employeeId = employeeId;
        this.name = name;
        this.experties = experties;
        this.designation = designation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExperties() {
        return experties;
    }

    public void setExperties(String experties) {
        this.experties = experties;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
