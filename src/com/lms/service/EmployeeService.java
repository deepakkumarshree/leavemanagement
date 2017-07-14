package com.lms.service;

import java.util.List;

import com.lms.model.Employee;

public interface EmployeeService {
	
	public void addEmployee(Employee employee);
	
    public List<Employee> listEmployees();
	
	public Employee getEmployee(int empid);
	
	public void deleteEmployee(Employee employee);	


}
