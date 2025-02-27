package com.bridgelabz.employeepayrollapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeePayrollDTO {
    private String name;
    private long salary;

    public EmployeePayrollDTO(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }
}
