package com.cg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	
	//public List<Product> findByPName(String name);

	public List<Employee> findByName(String name);
}
