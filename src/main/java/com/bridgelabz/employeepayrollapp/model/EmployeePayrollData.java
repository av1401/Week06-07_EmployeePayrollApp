package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;

public class EmployeePayrollData {
    private int id;
    private String name;
    private double salary;
    int employeeId;

    public EmployeePayrollData(int id, EmployeePayrollDTO employeePayrollDTO) {
        this.id = id;
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
