package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.IEmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class EmployeePayrollService {

    @Autowired
    private IEmployeePayrollRepository employeeRepository; // Use JPA Repository

    //  Get All Employees
    public List<EmployeePayrollData> getAllEmployees() {
        return employeeRepository.findAll(); // Fetch from DB
    }

    //  Get Employee by ID
    public EmployeePayrollData getEmployeeById(int empId) {
        return employeeRepository.findById(empId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + empId + " not found!"));
    }

    //  Create Employee
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData newEmployee = new EmployeePayrollData(
                0, // ID is auto-generated
                employeePayrollDTO.getName(),
                employeePayrollDTO.getSalary(),
                employeePayrollDTO.getGender(),
                LocalDate.parse(employeePayrollDTO.getStartDate(), DateTimeFormatter.ofPattern("dd MMM yyyy")),
                employeePayrollDTO.getNote(),
                employeePayrollDTO.getProfilePic(),
                employeePayrollDTO.getDepartment()
        );

        return employeeRepository.save(newEmployee); // Save to DB
    }

    // Update Employee
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData existingEmployee = getEmployeeById(empId);

        existingEmployee.setName(employeePayrollDTO.getName());
        existingEmployee.setSalary(employeePayrollDTO.getSalary());
        existingEmployee.setGender(employeePayrollDTO.getGender());
        existingEmployee.setStartDate(LocalDate.parse(employeePayrollDTO.getStartDate(), DateTimeFormatter.ofPattern("dd MMM yyyy")));
        existingEmployee.setNote(employeePayrollDTO.getNote());
        existingEmployee.setProfilePic(employeePayrollDTO.getProfilePic());
        existingEmployee.setDepartments(employeePayrollDTO.getDepartment());

        return employeeRepository.save(existingEmployee); // Save updated data
    }

    // Delete Employee
    public void deleteEmployeePayrollData(int empId) {
        if (!employeeRepository.existsById(empId)) {
            throw new EmployeeNotFoundException("Employee with ID " + empId + " not found!");
        }
        employeeRepository.deleteById(empId); // Delete from DB
    }
}
