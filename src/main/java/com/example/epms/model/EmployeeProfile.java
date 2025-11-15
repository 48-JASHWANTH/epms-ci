package com.example.epms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee_profile")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeProfile {
    @Id
    private Integer employeeId;
    private String name;
    private String mobile;
    private String email;
    private String linkedInUrl;
}
