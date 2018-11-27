package com.paymonk.service;

import com.paymonk.model.EmployeeCO;
import com.paymonk.model.EmployeeDTO;
import com.paymonk.model.ManagerCO;
import com.paymonk.model.ManagerDTO;

import java.util.List;

public interface ManagerService {


    public String save(EmployeeCO employeeCO, ManagerCO managerCO);

    public ManagerDTO getManagerId(long id);

    void update(long id, ManagerCO managerCO);

     public void delete(long id);

    public List<EmployeeDTO> listValue();

    public List<ManagerDTO> AllList();
}
