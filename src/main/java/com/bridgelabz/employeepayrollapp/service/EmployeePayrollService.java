package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.*;

@Service
public class EmployeePayrollService {

    private List<EmployeePayrollData> employeeList = new ArrayList<>(); // Simulated database

    public List<EmployeePayrollData> getAllEmployees() {
        return employeeList;
    }

    public EmployeePayrollData getEmployeeById(int empId) {
        return employeeList.stream()
                .filter(emp -> emp.getEmployeeId() == empId)
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + empId + " not found!"));
    }


    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData newEmployee = new EmployeePayrollData(employeeList.size() + 1, employeePayrollDTO.getName(), employeePayrollDTO.getSalary(), "Male", LocalDate.now(), new ArrayList<>());
        employeeList.add(newEmployee);
        return newEmployee;
    }

    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData emp = getEmployeeById(empId);
        emp.setName(employeePayrollDTO.getName());
        emp.setSalary(employeePayrollDTO.getSalary());
        return emp;
    }

    public void deleteEmployeePayrollData(int empId) {
        boolean removed = employeeList.removeIf(emp -> emp.getEmployeeId() == empId);
        if (!removed) {
            throw new EmployeeNotFoundException("Employee with ID " + empId + " not found");
        }
    }
}
