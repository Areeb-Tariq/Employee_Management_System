//package com.example.rest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//public class EmployeeService {
//    @Autowired
//     EmployeeRepo employeeRepo;
package com.example.rest;

import com.example.rest.Employee;
import com.example.rest.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.rest.Employee;
import com.example.rest.EmployeeRepo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*")
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo empRepository;


    public List<Employee> getAllEmployees(){
        return empRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return empRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource Not found") );
    }


    public Employee createEmployee(Employee emp) {
        return empRepository.save(emp);
    }

    public void deleteEmployee(Long id) {
        empRepository.deleteById(id);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee emp = empRepository.findById(id).get();
        emp.setName(employeeDetails.getName());
        emp.setEmail(employeeDetails.getEmail());

        return empRepository.save(emp);
    }
}
