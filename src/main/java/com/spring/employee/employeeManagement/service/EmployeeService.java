package com.spring.employee.employeeManagement.service;

import java.util.List;

import com.spring.employee.employeeManagement.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void deleteById(int id);
	
	public void saveOrUpdate(Employee employee);
}
