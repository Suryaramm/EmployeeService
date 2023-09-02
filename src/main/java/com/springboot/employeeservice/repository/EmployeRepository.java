package com.springboot.employeeservice.repository;

import com.springboot.employeeservice.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeRepository extends JpaRepository<Employe,Long> {
}
