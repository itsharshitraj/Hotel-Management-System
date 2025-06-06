package com.hotel.department_microservice.service;

import com.hotel.department_microservice.model.Department;
import com.hotel.department_microservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
    @Override
    public Optional<Department> getDepartmentById(int id){
        return departmentRepository.findById(id);
    }
    @Override
    public Department createDepartment(Department department){
        return departmentRepository.save(department);
    }
    @Override
    public Department updateDepartment(int id, Department updatedDepartment){
        Optional<Department> existingDepartment = departmentRepository.findById(id);
        if(existingDepartment.isPresent()){
            Department department = existingDepartment.get();
            department.setDepartmentName(updatedDepartment.getDepartmentName());
            department.setAvgSalary(updatedDepartment.getAvgSalary());
            department.setNoOfEmployees(updatedDepartment.getNoOfEmployees());
            return departmentRepository.save(department);
        }
        return null;
    }
   @Override
    public void deleteDepartment(int id){
        departmentRepository.deleteById(id);

   }

}
