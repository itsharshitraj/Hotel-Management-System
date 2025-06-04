package com.hotel.employee_microservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @Column(nullable = false)
    private String employeeName;

    @Column(nullable = false, unique = true)
    private long employeePhoneNo;

    @Column(nullable = false, unique = true)
    private String employeeEmailId;

    @Column(nullable = false)
    private String employeeAddress;

    @Column(name = "employee_department_id", nullable = false)
    private int departmentId;

    @Column(nullable = false)
    private double employeeSalary;

    @Transient // Do not persist this in db
    private Department department;
}
