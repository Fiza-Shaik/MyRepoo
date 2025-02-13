package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.entity.Employee;

public interface IEmployeeService {
    public List<Employee> findAllEmployees();
    
    public Employee findByEmployeeId(int id);
    
    public List<Employee> findEmployeeByName(String name);
    
    public Object deleteEmployeeById(int id);
    
    public Employee newEmployee(Employee employee);
    
    public void updateEmployee(Employee employee, Integer id);
}
