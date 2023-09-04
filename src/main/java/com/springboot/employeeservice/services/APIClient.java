package com.springboot.employeeservice.services;

import com.springboot.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="http://localhost:8081",value = "DEPARTMENT-SERVICE")
public interface APIClient {

    @GetMapping("api/department/code/{departmentCode}")
    DepartmentDto getDepartmentByCode(@PathVariable String departmentCode);

}
