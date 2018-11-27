package com.paymonk.dao;

import com.paymonk.domain.Employee;
import com.paymonk.domain.Manager;
import com.paymonk.model.ManagerCO;
import com.paymonk.model.ManagerDTO;

import java.util.List;

public interface ManagerDao {

   public String save(Employee employee, ManagerCO managerCO);

    public ManagerDTO getManagerId(long id);

    //List<Manager> list();

    void update(long id, ManagerCO managerCO);

    void delete(long id);

    public List<ManagerDTO> AllList();


}
