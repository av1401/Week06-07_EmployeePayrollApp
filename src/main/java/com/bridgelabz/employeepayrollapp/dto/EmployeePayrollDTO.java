package com.bridgelabz.employeepayrollapp.dto;

public class EmployeePayrollDTO {
    public String name;
    public double salary;

    public EmployeePayrollDTO(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }


}
