package com.spring.backed.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.backed.exceptions.ResourceNotFoundExceptions;
import com.spring.backed.model.Employee;
import com.spring.backed.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository empRepo;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return empRepo.findAll();
	}
	//create employee rest api
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return empRepo.save(employee);
	}
	
	//get employee by id
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee emp = empRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceptions("Employee id does not exist"+id));
		
		return ResponseEntity.ok(emp);
	}
	
	//update employee deatils
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployeeDetails(@PathVariable Long id, @RequestBody Employee employee) {
		Employee emp = empRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceptions("Employee id does not exist"+id));
		
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmail(employee.getEmail());
		
		Employee updateEmployee = empRepo.save(emp);
		
		return ResponseEntity.ok(updateEmployee);
	}
	
	// delete employee details
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id) {
		Employee emp = empRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceptions("Employee id does not exist"+id));
		empRepo.delete(emp);
		HashMap<String, Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
		
	}
}
