package com.springboot.employeeservice.services.serviceIml;

import com.springboot.employeeservice.dto.EmployeeDto;
import com.springboot.employeeservice.entity.Employe;
import com.springboot.employeeservice.mapper.EmployeeMapper;
import com.springboot.employeeservice.repository.EmployeRepository;
import com.springboot.employeeservice.services.EmployeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements EmployeService {

    private EmployeRepository employeRepository;

    public EmployeeServiceImp(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employe employee=new Employe(employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
        Employe savedEmployee= employeRepository.save(employee);
       EmployeeDto employeeDto1=new EmployeeDto(
               savedEmployee.getId(),
               savedEmployee.getFirstName(),
               savedEmployee.getLastName(),
               savedEmployee.getEmail()

       );
       return employeeDto1;
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
     Employe employe = employeRepository.findById(id).get();
        EmployeeDto employeeDto=new EmployeeDto(employe.getId(),
                employe.getFirstName(),
                employe.getLastName(),
                employe.getEmail()
        );
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {

       List<Employe>  allEmployee=employeRepository.findAll();
        return allEmployee.stream().map(EmployeeMapper::mapToDepartmentDto)
                .collect(Collectors.toList());



    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        Employe emp=employeRepository.findById(employeeDto.getId()).get();
           emp.setFirstName(employeeDto.getFirstName());
           emp.setLastName(employeeDto.getLastName());
           emp.setEmail(employeeDto.getEmail());
           Employe updatedEmploye=employeRepository.save(emp);
           return EmployeeMapper.mapToDepartmentDto(updatedEmploye);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeRepository.deleteById(id);
    }
}
