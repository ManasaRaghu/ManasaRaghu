package com.spring.backed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.backed.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
