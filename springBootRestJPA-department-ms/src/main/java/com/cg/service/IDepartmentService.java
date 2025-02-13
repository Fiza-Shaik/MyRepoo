package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.entity.Department;

public interface IDepartmentService {
	





	public List<Department> findAllDepartments();



	public Object findByDepartmentId(int id);



	public List<Department> findDepartmentByName(String name);



	public Object deleteDepartmentById(int id);



	public Department newDepartment(Department department);



	public void updateDepartment(Department department, int id);



	void updateDepartment(Department department, Integer id);



	
		
	}


