package com.hotel.employee_microservice.feign;

import com.hotel.employee_microservice.model.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Department-MicroService")
public interface DepartmentClient {
    @GetMapping("/departments/{id}")
    Department getDepartmentById(@PathVariable("id") int id);
}
