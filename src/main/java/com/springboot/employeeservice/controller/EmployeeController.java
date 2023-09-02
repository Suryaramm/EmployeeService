package com.springboot.employeeservice.controller;

import com.springboot.employeeservice.dto.EmployeeDto;
import com.springboot.employeeservice.entity.Employe;
import com.springboot.employeeservice.services.EmployeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    private EmployeService employeService;

    public EmployeeController(EmployeService employeService) {
        this.employeService = employeService;
    }
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
       EmployeeDto employeeDto1 =employeService.createEmployee(employeeDto);
       return  new ResponseEntity<>(employeeDto1, HttpStatus.CREATED);
    }
@GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeById(@PathVariable("id") Long id){
      EmployeeDto employeeDto=  employeService.getEmployeeById(id);
      return new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployes(){
        List<EmployeeDto> empAll=employeService.getAllEmployee();
        return new ResponseEntity<>(empAll,HttpStatus.OK);
    }
    @PutMapping("{id}")
     public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id,
             @RequestBody EmployeeDto employeeDto){
        employeeDto.setId(id);
        EmployeeDto employeeDto1=employeService.updateEmployee(employeeDto);
        return new ResponseEntity<>(employeeDto1,HttpStatus.OK);
     }
     @DeleteMapping("{id}")
     public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
         employeService.deleteEmployee(id);
         return new ResponseEntity<>("employee deleted successfully",HttpStatus.OK);
     }
}
