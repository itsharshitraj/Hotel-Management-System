package com.hotel.department_microservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;

    @Column(nullable = false, unique = true)
    private String departmentName;

    @Column(nullable = false )
    @Min(value = 1, message = " Salary must be greater than 15000")
    private float avgSalary;

    @Column(nullable = false)
    private int noOfEmployees;
}
