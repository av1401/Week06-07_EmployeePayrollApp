package com.bridgelabz.employeepayrollapp.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_payroll")
public class EmployeePayrollData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;  //  Ensure it matches service method calls

    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;

    @ElementCollection
    private List<String> departments;

    // ✅ Manually add the getter (Lombok might not generate correctly)
    public int getEmployeeId() {
        return employeeId;
    }
}
