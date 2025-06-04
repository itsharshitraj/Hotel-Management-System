package com.hotel.department_microservice.service;

import com.hotel.department_microservice.model.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    List<Department> getAllDepartments();
    Optional<Department> getDepartmentById(int id);
    Department createDepartment(Department department);
    Department updateDepartment(int id, Department updatedDepartment);
    void deleteDepartment(int id);
}
