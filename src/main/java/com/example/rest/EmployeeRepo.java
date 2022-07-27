package com.example.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.rest.Employee;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="*",allowedHeaders = "*")
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
