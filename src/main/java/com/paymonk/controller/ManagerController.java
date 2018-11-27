package com.paymonk.controller;


import com.paymonk.model.EmployeeCO;
import com.paymonk.model.EmployeeDTO;
import com.paymonk.model.ManagerCO;
import com.paymonk.model.ManagerDTO;
import com.paymonk.service.EmployeeService;
import com.paymonk.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Paymonk")
public class ManagerController {


    @Autowired
    private ManagerService managerService;

    @Autowired
    private EmployeeService employeeService;

    /* to add an employeee*/

    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public String save(@RequestBody @Valid EmployeeCO employeeCO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "not success";
        } else {
            return managerService.save(employeeCO, employeeCO.getManager());
        }

        //long id = employeeService.save(employeeCo);
        // return "New Employee has been saved with PROFILE:" + id;
        //return employeeCo;

    }

    /* to get all employee*/
    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public List<EmployeeDTO> list() {
        List<EmployeeDTO> employeeDto = managerService.listValue();
        return employeeDto;
    }

    /* to get all manager*/
    @RequestMapping(value = "/read/manager", method = RequestMethod.GET)
    public List<ManagerDTO> list1() {
        List<ManagerDTO> managerDto = managerService.AllList();
        return managerDto;
    }



    /*to get an employee by id*/

    @RequestMapping(value = "/read/{id}", method = RequestMethod.POST)
    public ResponseEntity<EmployeeDTO> get(@PathVariable("id") long id) {
        EmployeeDTO employeeDto = employeeService.getEmployeeId(id);
        return ResponseEntity.ok().body(employeeDto);

    }

    /* to get a manager by id*/

    @RequestMapping(value = "/read/manager/{id}", method = RequestMethod.POST)
    public ResponseEntity<ManagerDTO> getAll(@PathVariable("id") long id) {
        ManagerDTO managerDTO = managerService.getManagerId(id);
        return ResponseEntity.ok().body(managerDTO);
    }

    /* update manager by id */

    @RequestMapping(value = "/add/manager/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody ManagerCO managerCO) {
        managerService.update(id, managerCO);
        return ResponseEntity.ok().body("Manager has been updated successfully.");
    }

    /* update employee by id*/

    @RequestMapping(value = "/add/employee/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody EmployeeCO employeeCO) {
        employeeService.update(id, employeeCO);
        return ResponseEntity.ok().body("Employee has been updated successfully");
    }





    /* to delete an employee by id*/

    @RequestMapping(value = "/del/employee/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") long id, @RequestBody EmployeeCO employeeCO) {
        employeeService.delete(id);
        return ResponseEntity.ok().body("Employee has been deleted successfully.");
    }

    /* to delete a manager by id*/

    @RequestMapping(value = "/del/manager/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") long id, @RequestBody ManagerCO managerCO) {
        managerService.delete(id);
        return ResponseEntity.ok().body("Manager has been deleted successfully");

    }

}
