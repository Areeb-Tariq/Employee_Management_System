package com.example.rest;

//import com.example.rest.basicAuth.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping(path = "/basicauth")
//    public Authentication Auth() {
//        //throw new RuntimeException("SOMETHING HAS CHANGEEEEDDDDD");
//        return new Authentication("You are authenticated");
//    }

    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @RequestMapping(value="/employees", method= RequestMethod.GET)
    public List<Employee> readEmployees(){
            return employeeService.getAllEmployees();
        }

    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @RequestMapping(value="/employees/{id}",method=RequestMethod.GET)
    public Employee readByID(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

//    @RequestMapping(value="/employees", method=RequestMethod.POST)
//    public Employee createEmployee(@RequestBody Employee emp) {
//        return employeeService.createEmployee(emp);
//    }
    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @RequestMapping(value="/employees/", method=RequestMethod.POST)
    public Employee makeEmployees(@RequestBody Employee empDetails) {
        return employeeService.createEmployee(empDetails);

    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorld helloWorldBean() {
        //throw new RuntimeException("SOMETHING HAS CHANGEEEEDDDDD");
        return new HelloWorld("Hello World - Changed");
    }


    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorld helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorld(String.format("Hello World, %s", name));
    }


    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @RequestMapping(value="/employees/{id}", method=RequestMethod.DELETE)
    public void deleteEmployees(@PathVariable(value = "id") Long id) {
        employeeService.deleteEmployee(id);
    }

    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @RequestMapping(value="/employees/{id}", method=RequestMethod.PUT)
    public Employee readEmployees(@PathVariable(value = "id") Long id, @RequestBody Employee empDetails) {
        return employeeService.updateEmployee(id, empDetails);
    }
    }


