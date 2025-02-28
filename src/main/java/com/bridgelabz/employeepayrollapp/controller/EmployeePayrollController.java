package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeePayrollController.class);

    @Autowired
    private EmployeePayrollService employeePayrollService;

    @GetMapping("/all")
    public List<EmployeePayrollData> getAllEmployees() {
        logger.info("Received GET request to fetch all employees");
        return employeePayrollService.getAllEmployees();
    }

    @GetMapping("/{empId}")
    public EmployeePayrollData getEmployeeById(@PathVariable int empId) {
        logger.info("Received GET request for employee ID: {}", empId);
        return employeePayrollService.getEmployeeById(empId);
    }

    @PostMapping("/create")
    public EmployeePayrollData createEmployee(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        logger.info("Received POST request to create employee: {}", employeePayrollDTO.getName());
        return employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
    }

    @PutMapping("/update/{empId}")
    public EmployeePayrollData updateEmployee(@PathVariable int empId, @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        logger.info("Received PUT request to update employee ID: {}", empId);
        return employeePayrollService.updateEmployeePayrollData(empId, employeePayrollDTO);
    }

    @DeleteMapping("/delete/{empId}")
    public String deleteEmployee(@PathVariable int empId) {
        logger.warn("Received DELETE request for employee ID: {}", empId);
        employeePayrollService.deleteEmployeePayrollData(empId);
        return "Employee with ID " + empId + " deleted successfully!";
    }
}
