package com.vivek.employee_management.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vivek.employee_management.dto.ApiResponse;
import com.vivek.employee_management.entity.Employee;
import com.vivek.employee_management.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class); 
	
    @Autowired
    private EmployeeService service;

    @PostMapping
    public ApiResponse<Employee> create(@Valid @RequestBody Employee emp)  {
        logger.info("Creating employee with name: {}", emp.getName());

        Employee saved = service.save(emp);

        return new ApiResponse<>("SUCCESS", "Employee created successfully", saved);
    }

    @GetMapping
    public ApiResponse<List<Employee>> getAll() {
        logger.info("Fetching all employees");

        return new ApiResponse<>("SUCCESS", "Employees fetched successfully", service.getAll());
    }
    
    @PutMapping("/{id}")
    public ApiResponse<Employee> update(@PathVariable Long id, @Valid @RequestBody Employee emp) {
        logger.info("Updating employee with id: {}", id);

        return new ApiResponse<>("SUCCESS", "Employee updated successfully", service.update(id, emp));
    }
}