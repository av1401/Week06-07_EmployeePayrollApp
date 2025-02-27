package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

@Service
public class EmployeePayrollService {

    public EmployeePayrollData getEmployeePayrollData() {
        return new EmployeePayrollData(1, new EmployeePayrollDTO("John Doe", 50000));
    }

    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        return new EmployeePayrollData(2, employeePayrollDTO);
    }
}

