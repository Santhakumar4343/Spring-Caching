package com.caching.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.caching.entity.Employee;
import com.caching.repository.EmployeeRepository;
import com.caching.service.EmployeeService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
	  @Autowired
	  private EmployeeRepository employeeRepository;
	@Override
	public Employee addEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	@Cacheable(value="employee",key="#id")
	public Employee getEmployee(int id) {
		 System.err.println("*****************************************called");
		  Employee emp=employeeRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Employee not found with id: "+id));
		return emp;
	}

	@Override
	@CachePut(value="employee",key = "#id")
	public Employee updateEmployee(int id, Employee employee) {
		  
		Employee updateEmployee=employeeRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Employee not found with id :"+id));
		
		updateEmployee.setEmail(employee.getEmail());
		updateEmployee.setName(employee.getName());
		updateEmployee.setPassword(employee.getPassword());
		    System.err.println("*****************************************called");
		return employeeRepository.save(updateEmployee);
	}

	@Override
	@CacheEvict(value = "employee",key = "#id")
	public void deleteEmployee(int id) {
		 System.err.println("*****************************************called");
		 employeeRepository.deleteById(id);
	}

}
