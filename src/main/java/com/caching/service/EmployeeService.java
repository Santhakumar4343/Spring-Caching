package com.caching.service;

import com.caching.entity.Employee;

public interface EmployeeService {

	 public Employee addEmployee(Employee employee);
	 public Employee getEmployee(int id);
	 public Employee updateEmployee(int id,Employee employee);
	 public void deleteEmployee(int id);
}
