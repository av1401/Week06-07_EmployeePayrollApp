package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    /*
    ----------------- Section 2 UC1 Code  -----------------

    @GetMapping("/get")
    public EmployeePayrollData getEmployeePayrollData() {
        return new EmployeePayrollData(1, new EmployeePayrollDTO("John Doe", 50000));
    }

    @PostMapping("/create")
    public EmployeePayrollData createEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        return new EmployeePayrollData(2, employeePayrollDTO);
    }

    -----------------------------------------------------------------
    */

    @Autowired
    private EmployeePayrollService employeePayrollService;

    // Section 2 UC2: Introducing Service Layer
    @GetMapping("/get")
    public EmployeePayrollData getEmployeePayrollData() {
        return employeePayrollService.getEmployeePayrollData();
    }

    @PostMapping("/create")
    public EmployeePayrollData createEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        return employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
    }
}
