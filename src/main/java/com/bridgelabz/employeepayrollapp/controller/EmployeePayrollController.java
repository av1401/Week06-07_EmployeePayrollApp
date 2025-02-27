package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    @GetMapping("/get")
    public List<EmployeePayrollData> getAllEmployees() {
        return employeePayrollService.getAllEmployees();
    }

    @GetMapping("/get/{empId}")
    public EmployeePayrollData getEmployeeById(@PathVariable int empId) {
        return employeePayrollService.getEmployeeById(empId);
    }

    @PostMapping("/create")
    public EmployeePayrollData createEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        return employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
    }

    @PutMapping("/update/{empId}")
    public EmployeePayrollData updateEmployeePayrollData(@PathVariable int empId, @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        return employeePayrollService.updateEmployeePayrollData(empId, employeePayrollDTO);
    }

    @DeleteMapping("/delete/{empId}")
    public void deleteEmployeePayrollData(@PathVariable int empId) {
        employeePayrollService.deleteEmployeePayrollData(empId);
    }
}
