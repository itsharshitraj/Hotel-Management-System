package com.hotel.employee_microservice.model;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private int departmentId;
    private String departmentName;
    private double avgSalary;
    private int noOfEmployees;
}
