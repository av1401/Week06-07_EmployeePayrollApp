package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService {

    /*
    ----------------- Section 2 UC2 Code  -----------------

    public EmployeePayrollData getEmployeePayrollData() {
        return new EmployeePayrollData(1, new EmployeePayrollDTO("John Doe", 50000));
    }

    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        return new EmployeePayrollData(2, employeePayrollDTO);
    }

    -----------------------------------------------------------------
    */

    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    public List<EmployeePayrollData> getAllEmployees() {
        return employeePayrollList;
    }

    public EmployeePayrollData getEmployeeById(int empId) {
        return employeePayrollList.stream()
                .filter(emp -> emp.getEmployeeId() == empId)
                .findFirst()
                .orElse(null);
    }

    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData newEmployee = new EmployeePayrollData(employeePayrollList.size() + 1, employeePayrollDTO);
        employeePayrollList.add(newEmployee);
        return newEmployee;
    }

    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employee = getEmployeeById(empId);
        if (employee != null) {
            employee.setName(employeePayrollDTO.getName());
            employee.setSalary(employeePayrollDTO.getSalary());
        }
        return employee;
    }

    public void deleteEmployeePayrollData(int empId) {
        employeePayrollList.removeIf(emp -> emp.getEmployeeId() == empId);
    }
}
