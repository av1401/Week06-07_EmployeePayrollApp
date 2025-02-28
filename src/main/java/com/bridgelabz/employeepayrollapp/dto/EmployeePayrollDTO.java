package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.List;

@Data
public class EmployeePayrollDTO {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Min(value = 5000, message = "Salary should be greater than 5000")
    private long salary;

    @Pattern(regexp = "male|female", message = "Gender should be male or female")
    private String gender;

    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "Start date should not be empty")
    private LocalDate startDate;

    @NotBlank(message = "Note cannot be blank")
    private String note;

    @NotBlank(message = "Profile picture URL is required")
    private String profilePic;

    @NotNull(message = "Department should not be empty")
    private List<String> department;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
