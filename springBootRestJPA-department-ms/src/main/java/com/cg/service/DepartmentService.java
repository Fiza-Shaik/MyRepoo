package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Department;
import com.cg.repository.DepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    List<Department> departmentList = new ArrayList<>();
    
    @Override
    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }
    
    @Override
    public Department findByDepartmentId(int id) {
        return departmentRepository.findById(id).orElse(null);
    }
    
    @Override
    public List<Department> findDepartmentByName(String name) {
        return departmentRepository.findByName(name);
    }
    
    @Override
    public Object deleteDepartmentById(int id) {
        departmentRepository.deleteById(id);
        return id;
    }
    
    @Override
    public Department newDepartment(Department department) {
        return departmentRepository.save(department);
    }



	@Override
	public void updateDepartment(Department department, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDepartment(Department department, Integer id) {
		// TODO Auto-generated method stub
		
	}

	
    
    
    }

