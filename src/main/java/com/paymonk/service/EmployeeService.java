package com.paymonk.service;

import com.paymonk.domain.Employee;
import com.paymonk.model.EmployeeCO;
import com.paymonk.model.EmployeeDTO;

import java.util.List;


public interface EmployeeService {

/*
    long save(EmployeeCO employeeCO);

    Employee get(long id);

    List<Employee> list();
*/
     void update(long id, EmployeeCO employeeCO);

    public void delete(long id);

    public EmployeeDTO getEmployeeId(Long id);
}
