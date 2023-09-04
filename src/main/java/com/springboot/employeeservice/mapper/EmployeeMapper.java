package com.springboot.employeeservice.mapper;

import com.springboot.employeeservice.dto.EmployeeDto;
import com.springboot.employeeservice.entity.Employe;

public class EmployeeMapper {

    public static EmployeeDto mapToDepartmentDto(Employe department){
        EmployeeDto departmentDto = new EmployeeDto(
                department.getId(),
                department.getFirstName(),
                department.getLastName(),
                department.getEmail(),
                department.getDepartmentCode()
        );
        return departmentDto;
    }

    public static Employe mapToDepartment(EmployeeDto departmentDto){
        Employe department = new Employe(
                departmentDto.getId(),
                departmentDto.getFirstName(),
                departmentDto.getLastName(),
                departmentDto.getEmail(),
                departmentDto.getDepartmentCode()
        );
        return department;
    }
}
