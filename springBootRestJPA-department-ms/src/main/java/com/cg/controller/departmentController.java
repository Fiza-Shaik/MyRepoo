package com.cg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Department;

import com.cg.service.IDepartmentService;
import com.cg.feign.DepartmentFeignClient;

@RestController
@RequestMapping("/dapi")
public class departmentController {
    @Autowired
    IDepartmentService departmentService;
    
    @Autowired
    DepartmentFeignClient departmentFeign; 
    
    
    @GetMapping("/hello")
    public String show() {
        return "hello SpringRest";
    }
    
    @GetMapping("/departments/all")
    public List<Department> getAllDepartments() {
        return departmentService.findAllDepartments();
    }
    
//    @GetMapping("/departments/{id}")
//    public Department getDepartmentById(@PathVariable int id) throws ResourceNotFoundException {
//        return departmentService.findByDepartmentId(id).orElseThrow(() -> new ResourceNotFoundException("Department not found for this id :: " + id));
//    }
//    
    @GetMapping("/departments/name/{name}")
    public List<Department> getDepartmentByName(@PathVariable String name) {
        return departmentService.findDepartmentByName(name);
    }
    
//    @GetMapping("/departments")
//    public List<Department> getDepartmentByName1(@RequestParam String name) {
//        return departmentService.findDepartmentByName(name);
//    }
    
    @DeleteMapping("/departments/remove/{id}")
    public Object deleteDepartmentById(@PathVariable int id) {
        return departmentService.deleteDepartmentById(id);
    }
    
    @PostMapping("/departments")
    public Department createDepartment(@RequestBody Department department) {
        Department dept = departmentService.newDepartment(department);
        return dept;
    }
    
    @PutMapping("/departments/{id}")
    public void updateDepartment(@PathVariable int id, @RequestBody Department department) {
        departmentService.updateDepartment(department, id);
        System.out.println("Updated");
    }
    
    @GetMapping("/allemp")
    public ResponseEntity<String> getEmployees() {
        return ResponseEntity.ok().body(departmentFeign.employeeResponse());
    }
}
