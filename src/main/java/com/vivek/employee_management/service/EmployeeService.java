package com.vivek.employee_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivek.employee_management.entity.Employee;
import com.vivek.employee_management.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public Employee save(Employee emp) {
        return repo.save(emp);
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }
    
    public Employee update(Long id, Employee emp) {
        Employee existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        existing.setName(emp.getName());
        existing.setRole(emp.getRole());

        return repo.save(existing);
    }
}