package com.cg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Employee;
import com.cg.exception.ResourceNotFoundException;
import com.cg.repository.EmployeeRepository;
import com.cg.service.IEmployeeService;

@RestController
@RequestMapping("/papi")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    
    @GetMapping("/hello")
    public String show() {
        return "hello SpringRest";
    }
    
    @GetMapping("/employees/all")
    public List<Employee> getAllEmployees() {
        return employeeService.findAllEmployees();
    }
    
//    @GetMapping("/employees/{id}")
//    public Employee getEmployeeById(@PathVariable int id) throws ResourceNotFoundException {
//        return employeeService.findByEmployeeId(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
//    }
    
    @GetMapping("/employees/name/{name}")
    public List<Employee> getEmployeeByName(@PathVariable String name) {
        return employeeService.findEmployeeByName(name);
    }
    
    @GetMapping("/employees")
    public List<Employee> getEmployeeByName1(@RequestParam String name) {
        return employeeService.findEmployeeByName(name);
    }
    
    @DeleteMapping("/employees/remove/{id}")
    public Object deleteEmployeeById(@PathVariable int id) {
        return employeeService.deleteEmployeeById(id);
    }
    
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        Employee emp = employeeService.newEmployee(employee);
        return emp;
    }
    
    @PutMapping("/employees/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employeeService.updateEmployee(employee, id);
        System.out.println("Updated");
    }
}
