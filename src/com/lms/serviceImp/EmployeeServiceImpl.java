package com.lms.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lms.dao.EmployeeDao;
import com.lms.model.Employee;
import com.lms.service.EmployeeService;

@Service("employeeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly=false)
	public void addEmployee(Employee employee) {
	    
	     employeeDao.addEmployee(employee);
		
	}

	@Override
	public List<Employee> listEmployees() {
		
		return employeeDao.listEmployees();
	}

	@Override
	public Employee getEmployee(int empid) {
		return employeeDao.getEmployee(empid);
		 
	}

	@Override
	public void deleteEmployee(Employee employee) {
		employeeDao.deleteEmployee(employee);
		
	}

}
