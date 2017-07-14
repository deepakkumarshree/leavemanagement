package com.lms.daoImp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lms.dao.EmployeeDao;
import com.lms.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addEmployee(Employee employee) {
		this.sessionFactory.getCurrentSession().save(employee);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> listEmployees() {
       return sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
	}

	@Override
	public Employee getEmployee(int empid) {
		
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, empid);
	}

	@Override
	public void deleteEmployee(Employee employee) {
	     sessionFactory.getCurrentSession().delete(Employee.class);
	}

}
