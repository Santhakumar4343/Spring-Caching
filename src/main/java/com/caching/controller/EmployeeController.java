package com.caching.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caching.entity.Employee;
import com.caching.service.EmployeeService;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/save")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
		try {
			Employee empl=employeeService.addEmployee(employee);
			return ResponseEntity.ok(empl);
		}
		catch (Exception e) {
			    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving Integration"+e.getMessage());
		}
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable int id){
		
	      try {
	    	  Employee emp=employeeService.getEmployee(id);
	    	  return ResponseEntity.ok(emp);
	      }
	      catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Employee geting Employeee with id "+id+e.getMessage());
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable int id,@RequestBody Employee employee){
		
		try{Employee emp=employeeService.updateEmployee(id, employee);
		return ResponseEntity.ok(emp);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating employee with id : "+id+e.getMessage());
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable int id) {
		 
		employeeService.deleteEmployee(id);
	}
	

}
