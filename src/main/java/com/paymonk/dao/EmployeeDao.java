package com.paymonk.dao;

import com.paymonk.domain.Employee;
import com.paymonk.model.EmployeeCO;
import com.paymonk.model.EmployeeDTO;

import java.util.List;


public interface EmployeeDao {

  public  Employee save(EmployeeCO employeeCO);

    public EmployeeDTO getEmployeeId(long id);

    //public List<Employee> list();

    public void update(long id, EmployeeCO employeeCO);

    public  void delete(long id);

    public List<EmployeeDTO> listValue();


}


