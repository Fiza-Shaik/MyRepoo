package com.cg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Integer>{

	
	//public List<Product> findByPName(String name);

	public List<Department> findByName(String name);
}
