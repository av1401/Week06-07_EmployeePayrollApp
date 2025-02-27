package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    public List<EmployeePayrollData> getAllEmployees() {
        return employeePayrollRepository.findAll();
    }

    public EmployeePayrollData getEmployeeById(int empId) {
        return employeePayrollRepository.findById(empId)
                .orElseThrow(() -> new EmployeePayrollException("Employee with ID " + empId + " not found!"));
    }

    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData newEmployee = new EmployeePayrollData(
                0,
                employeePayrollDTO.getName(),
                employeePayrollDTO.getSalary(),
                "Male",
                LocalDate.now(),
                null
        );
        return employeePayrollRepository.save(newEmployee);
    }

    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData emp = getEmployeeById(empId);
        emp.setName(employeePayrollDTO.getName());
        emp.setSalary(employeePayrollDTO.getSalary());
        return employeePayrollRepository.save(emp);
    }

    public void deleteEmployeePayrollData(int empId) {
        if (!employeePayrollRepository.existsById(empId)) {
            throw new EmployeePayrollException("Cannot delete! Employee with ID " + empId + " does not exist.");
        }
        employeePayrollRepository.deleteById(empId);
    }
}
