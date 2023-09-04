package com.springboot.employeeservice.services.serviceIml;

import com.springboot.employeeservice.dto.APIResponseDto;
import com.springboot.employeeservice.dto.DepartmentDto;
import com.springboot.employeeservice.dto.EmployeeDto;
import com.springboot.employeeservice.entity.Employe;
import com.springboot.employeeservice.mapper.EmployeeMapper;
import com.springboot.employeeservice.repository.EmployeRepository;
import com.springboot.employeeservice.services.APIClient;
import com.springboot.employeeservice.services.EmployeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service


public class EmployeeServiceImp implements EmployeService {
@Autowired
    private EmployeRepository employeRepository;
@Autowired
    private APIClient apiClient;

//    public EmployeeServiceImp(EmployeRepository employeRepository) {
//        this.employeRepository = employeRepository;
//    }
//    public EmployeeServiceImp(EmployeRepository employeRepository, APIClient apiClient) {
//        this.employeRepository = employeRepository;
//        this.apiClient = apiClient;
//    }

    public EmployeeServiceImp() {
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employe employee=new Employe(employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()

        );
        Employe savedEmployee= employeRepository.save(employee);
       EmployeeDto employeeDto1=new EmployeeDto(
               savedEmployee.getId(),
               savedEmployee.getFirstName(),
               savedEmployee.getLastName(),
               savedEmployee.getEmail(),
               savedEmployee.getDepartmentCode()

       );
       return employeeDto1;
    }

    @Override
    public APIResponseDto getEmployeeById(Long id) {
     Employe employe = employeRepository.findById(id).get();

    DepartmentDto departmentDto= apiClient.getDepartmentByCode(employe.getDepartmentCode());
        EmployeeDto employeeDto=new EmployeeDto(employe.getId(),
                employe.getFirstName(),
                employe.getLastName(),
                employe.getEmail(),
                employe.getDepartmentCode()



        );
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;
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
