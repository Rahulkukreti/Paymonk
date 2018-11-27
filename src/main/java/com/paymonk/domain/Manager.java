package com.paymonk.domain;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "Manager")
public class Manager implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_id")
    private Long id;

    @NotBlank
    @Column(name = "department")
    private String department;

    @Column(name = "Salary")
    private Float salary;

    @NotBlank
    @Column(name = "address")
    private String address;

    @OneToOne
    @JoinColumn(name = "FK_employeeId")
    private Employee employee;

    public Manager() {

    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Long getId() {
        return id;
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






















