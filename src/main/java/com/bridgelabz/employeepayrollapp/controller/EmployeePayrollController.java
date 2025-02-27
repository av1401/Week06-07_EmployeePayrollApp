package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    @GetMapping("/get")
    public ResponseEntity<List<EmployeePayrollData>> getAllEmployees() {
        return ResponseEntity.ok(employeePayrollService.getAllEmployees());
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<EmployeePayrollData> getEmployeeById(@PathVariable int empId) {
        EmployeePayrollData employee = employeePayrollService.getEmployeeById(empId);
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeePayrollData> createEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData newEmployee = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
        return ResponseEntity.ok(newEmployee);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<EmployeePayrollData> updateEmployeePayrollData(@PathVariable int empId, @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData updatedEmployee = employeePayrollService.updateEmployeePayrollData(empId, employeePayrollDTO);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable int empId) {
        employeePayrollService.deleteEmployeePayrollData(empId);
        return ResponseEntity.ok("Employee with ID " + empId + " deleted successfully");
    }
}
