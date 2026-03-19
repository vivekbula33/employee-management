package com.vivek.employee_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vivek.employee_management.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}