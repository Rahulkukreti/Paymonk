package com.paymonk.model;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EmployeeCO {

    @NotBlank
    private String name;

    @NotBlank

    private String experties;

    @NotBlank
    private String designation;

    @NotNull
    @Valid
    private ManagerCO managerCO;

    public ManagerCO getManager() {
        return managerCO;
    }

    public void setManager(ManagerCO manager) {
        this.managerCO = manager;
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

