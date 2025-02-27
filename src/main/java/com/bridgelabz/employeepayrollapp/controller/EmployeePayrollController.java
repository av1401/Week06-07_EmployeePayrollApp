package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    /*
    ----------------- Section 1 Code (Commented Out) -----------------

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Employee Payroll App!";
    }

    @GetMapping("/hello/query")
    public String sayHello(@RequestParam String name) {
        return "Hello " + name + "!";
    }

    @GetMapping("/hello/{name}")
    public String sayHelloParam(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    -----------------------------------------------------------------
    */

    // Section 2 UC1: Introducing DTO and Model
    @GetMapping("/get")
    public EmployeePayrollData getEmployeePayrollData() {
        return new EmployeePayrollData(1, new EmployeePayrollDTO("John Doe", 50000));
    }

    @PostMapping("/create")
    public EmployeePayrollData createEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        return new EmployeePayrollData(2, employeePayrollDTO);
    }
}
