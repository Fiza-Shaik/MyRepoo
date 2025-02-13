package com.cg.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="employee-service",url="http://localhost:9090")
public interface DepartmentFeignClient {
	@GetMapping("eapi/employee")
	public String employeeResponse();

}
