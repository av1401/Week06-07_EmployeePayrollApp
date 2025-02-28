package com.bridgelabz.employeepayrollapp.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class EmployeePayrollDTO {
    private String name;
    private long salary;
    private String gender;
    private String startDate;
    private String note;
    private String profilePic;
    private List<String> department;

    public EmployeePayrollDTO(String name, long salary, String gender, String startDate, String note, String profilePic, List<String> department) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.startDate = startDate;
        this.note = note;
        this.profilePic = profilePic;
        this.department = department;
    }
}
