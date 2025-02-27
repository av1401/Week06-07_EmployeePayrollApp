package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository; //  Inject Repository

    public List<EmployeePayrollData> getAllEmployees() {
        return employeePayrollRepository.findAll();
    }

    public EmployeePayrollData getEmployeeById(int empId) {
        return employeePayrollRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee Not Found!"));
    }

    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData newEmployee = new EmployeePayrollData(
                0, // Auto-generated ID
                employeePayrollDTO.getName(),
                employeePayrollDTO.getSalary(),
                "Male",
                LocalDate.now(),
                null
        );
        return employeePayrollRepository.save(newEmployee); // Save to database
    }

    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData emp = getEmployeeById(empId);
        emp.setName(employeePayrollDTO.getName());
        emp.setSalary(employeePayrollDTO.getSalary());
        return employeePayrollRepository.save(emp); //  Save updates to database
    }

    public void deleteEmployeePayrollData(int empId) {
        employeePayrollRepository.deleteById(empId); //  Delete from database
    }
}
