package com.paymonk.service.impl;

import com.paymonk.dao.EmployeeDao;
import com.paymonk.dao.ManagerDao;
import com.paymonk.domain.Employee;
import com.paymonk.model.EmployeeCO;
import com.paymonk.model.EmployeeDTO;
import com.paymonk.model.ManagerCO;
import com.paymonk.model.ManagerDTO;
import com.paymonk.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("managerService")
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerDao;


    @Autowired
    private EmployeeDao employeeDao;


    @Override
    public String save(EmployeeCO employeeCO, ManagerCO managerCO) {
        Employee employee = employeeDao.save(employeeCO);
        return managerDao.save(employee, managerCO);
    }

    @Override
    public ManagerDTO getManagerId(long id) {
        return managerDao.getManagerId(id);
    }


    @Override
    public void update(long id, ManagerCO managerCO) {

        managerDao.update(id, managerCO);
    }

    @Override
    public void delete(long id) {

        managerDao.delete(id);
    }

    @Override
    public List<EmployeeDTO> listValue() {
        return employeeDao.listValue();
    }

    @Override
    public List<ManagerDTO> AllList() {
        return managerDao.AllList();
    }

}
