package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.IEmployeePayrollRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePayrollService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeePayrollService.class);

    @Autowired
    private IEmployeePayrollRepository employeeRepository;

    public List<EmployeePayrollData> getAllEmployees() {
        logger.info("Fetching all employees");
        return employeeRepository.findAll();
    }

    public EmployeePayrollData getEmployeeById(int empId) {
        logger.info("Fetching employee with ID: {}", empId);
        return employeeRepository.findById(empId)
                .orElseThrow(() -> {
                    logger.error("Employee with ID {} not found!", empId);
                    return new EmployeeNotFoundException("Employee with ID " + empId + " not found!");
                });
    }

    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        logger.info("Creating a new employee: {}", employeePayrollDTO.getName());
        EmployeePayrollData newEmployee = new EmployeePayrollData(
                0,
                employeePayrollDTO.getName(),
                employeePayrollDTO.getSalary()
        );
        return employeeRepository.save(newEmployee);
    }

    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        logger.info("Updating employee with ID: {}", empId);
        EmployeePayrollData existingEmployee = getEmployeeById(empId);
        existingEmployee.setName(employeePayrollDTO.getName());
        existingEmployee.setSalary(employeePayrollDTO.getSalary());
        existingEmployee.setGender(employeePayrollDTO.getGender());
        existingEmployee.setStartDate(employeePayrollDTO.getStartDate());
        existingEmployee.setDepartments(employeePayrollDTO.getDepartments());
        return employeeRepository.save(existingEmployee);
    }

    public void deleteEmployeePayrollData(int empId) {
        logger.warn("Deleting employee with ID: {}", empId);
        EmployeePayrollData employee = getEmployeeById(empId);
        employeeRepository.delete(employee);
    }
}
