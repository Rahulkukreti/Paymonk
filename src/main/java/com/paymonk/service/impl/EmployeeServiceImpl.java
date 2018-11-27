package com.paymonk.service.impl;

import com.paymonk.dao.EmployeeDao;
import com.paymonk.model.EmployeeCO;
import com.paymonk.model.EmployeeDTO;
import com.paymonk.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;


    @Override
    public EmployeeDTO getEmployeeId(Long id) {
        return employeeDao.getEmployeeId(id);
    }

    @Override
    public void update(long id, EmployeeCO employeeCO) {
        employeeDao.update(id, employeeCO);
    }

    @Override
    public void delete(long id){
        employeeDao.delete(id);

    }
}
