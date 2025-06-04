package com.hotel.department_microservice.controller;

import com.hotel.department_microservice.model.Department;
import com.hotel.department_microservice.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
     public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Department>> getDepartmentById(@PathVariable int id) {
        Optional<Department> department = departmentService.getDepartmentById(id);
        return department.isPresent() ? ResponseEntity.ok(department) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody @Valid Department department) {
        Department savedDepartment = departmentService.createDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDepartment);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable int id, @RequestBody @Valid Department updatedDepartment){
        Department department =departmentService.updateDepartment(id, updatedDepartment);
        return department != null ? ResponseEntity.ok(department) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable int id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
}
