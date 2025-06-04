package com.hotel.employee_microservice.service;

import com.hotel.employee_microservice.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee addEmployee( Employee employee);
    List<Employee> getAllEmployees();
    Optional <Employee> getEmployeeById( int id);
    Employee updateEmployee(int id, Employee employee);
    void deleteEmployee(int id);
}
