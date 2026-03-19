package com.vivek.employee_management.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vivek.employee_management.entity.Employee;
import com.vivek.employee_management.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class); 
	
    @Autowired
    private EmployeeService service;

    @PostMapping
    public Employee create(@RequestBody Employee emp) {
        logger.info("Creating employee with name: {}", emp.getName());
        return service.save(emp);
    }

    @GetMapping
    public List<Employee> getAll() {
        logger.info("Fetching all employees");
        return service.getAll();
    }
    
    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee emp) {
        logger.info("Updating employee with id: {}", id);
        return service.update(id, emp);
    }
}