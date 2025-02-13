package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Employee;
import com.cg.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    List<Employee> employeeList = new ArrayList<>();
    
    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }
    
    @Override
    public Employee findByEmployeeId(int id) {
        return employeeRepository.findById(id).orElse(null);
    }
    
    @Override
    public List<Employee> findEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }
    
    @Override
    public Object deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
        return id;
    }
    
    @Override
    public Employee newEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    
    @Override
    public void updateEmployee(Employee employee, Integer id) {
        Employee e = employeeRepository.findById(id).orElse(null);
        if (e != null) {
            e.setName(employee.getName());
            e.setSalary(employee.getSalary());
            employeeRepository.save(e);
        }
    }
}
