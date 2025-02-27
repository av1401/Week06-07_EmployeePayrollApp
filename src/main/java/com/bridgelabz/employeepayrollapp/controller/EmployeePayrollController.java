package com.bridgelabz.employeepayrollapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    // GET Request - Welcome Message
    @GetMapping("/")
    public String getWelcomeMessage() {
        return "Welcome to Employee Payroll App!";
    }

    // GET Request - Get Employee by ID
    @GetMapping("/get/{id}")
    public String getEmployeeById(@PathVariable int id) {
        return "Fetching Employee with ID: " + id;
    }

    // POST Request - Create Employee
    @PostMapping("/create")
    public String createEmployee(@RequestBody String employeeData) {
        return "Employee Created: " + employeeData;
    }

    // PUT Request - Update Employee
    @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody String updatedData) {
        return "Employee Updated (ID: " + id + "): " + updatedData;
    }

    // DELETE Request - Delete Employee
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return "Employee Deleted with ID: " + id;
    }
}
