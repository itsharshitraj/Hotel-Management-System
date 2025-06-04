package com.hotel.employee_microservice.service;

import com.hotel.employee_microservice.feign.DepartmentClient;
import com.hotel.employee_microservice.model.Department;
import com.hotel.employee_microservice.model.Employee;
import com.hotel.employee_microservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentClient departmentClient;

    @Override
    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    @Override
    public List<Employee> getAllEmployees(){
        // return employeeRepository.findAll();
        List<Employee> employees = employeeRepository.findAll();
        for (Employee emp : employees) {
            Department dept = departmentClient.getDepartmentById(emp.getDepartmentId());
            emp.setDepartment(dept);  // Set full department details
        }
        return employees;
    }
    @Override
    public Optional<Employee> getEmployeeById(int id){
        // return employeeRepository.findById(id);
        Optional<Employee> employee = employeeRepository.findById(id);
        employee.ifPresent(emp -> {
            Department dept = departmentClient.getDepartmentById(emp.getDepartmentId());
            emp.setDepartment(dept);  // Set full department details
        });
        return employee;
    }
    @Override
    public void deleteEmployee(int id){
       employeeRepository.deleteById(id);
    }

    @Override
  public Employee updateEmployee(int id, Employee employee){
        Optional<Employee> existingEmployeeOpt = employeeRepository.findById(id);
        if (existingEmployeeOpt.isPresent()) {
            Employee existingEmployee = existingEmployeeOpt.get();
            existingEmployee.setEmployeeName(employee.getEmployeeName());
            existingEmployee.setEmployeePhoneNo(employee.getEmployeePhoneNo());
            existingEmployee.setEmployeeEmailId(employee.getEmployeeEmailId());
            existingEmployee.setEmployeeAddress(employee.getEmployeeAddress());
            existingEmployee.setDepartmentId(employee.getDepartmentId());
            existingEmployee.setEmployeeSalary(employee.getEmployeeSalary());
            return employeeRepository.save(existingEmployee);
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }


}