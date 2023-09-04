package com.springboot.employeeservice.dto;

public class DepartmentDto {
    private Long id;
    private String department_name;
    private String department_description;
    private String departmentCode;

    public DepartmentDto() {
    }

    public DepartmentDto(Long id, String department_name, String department_description, String departmentCode) {
        this.id = id;
        this.department_name = department_name;
        this.department_description = department_description;
        this.departmentCode = departmentCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getDepartment_description() {
        return department_description;
    }

    public void setDepartment_description(String department_description) {
        this.department_description = department_description;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
}
