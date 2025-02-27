package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class EmployeePayrollDTO {

    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Name should start with a capital letter and have at least 3 characters")
    private String name;

    @Min(value = 10000, message = "Salary must be at least 10,000")
    private long salary;

    @NotEmpty(message = "Gender is required")
    @Pattern(regexp = "Male|Female", message = "Gender must be Male or Female")
    private String gender;

    @PastOrPresent(message = "Start date must be a past or present date")
    private LocalDate startDate;

    @NotEmpty(message = "Department list cannot be empty")
    private List<String> departments;
}
