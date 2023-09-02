package com.springboot.employeeservice.services;

import com.springboot.employeeservice.dto.EmployeeDto;

import java.util.List;

public interface EmployeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);

    List<EmployeeDto> getAllEmployee();
    EmployeeDto updateEmployee(EmployeeDto employeeDto);
     void deleteEmployee(Long id);


}
