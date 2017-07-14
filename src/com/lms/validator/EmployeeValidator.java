package com.lms.validator;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lms.model.Employee;
import com.lms.service.EmployeeService;

@Component
public class EmployeeValidator implements Validator{
	
	@Autowired
	private EmployeeService employeeService;
		
    public void validate(Object o, Errors errors) {
		Employee employee = (Employee) o;
        
        if (employee.getMobile()!=null && (employee.getMobile().length() < 10 || employee.getMobile().length() > 10)) {
            errors.rejectValue("mobile", "mobile.error");
        }
        if (employeeService.getEmployee(employee.getId())!= null) {
            errors.rejectValue("id", "diff.userform.id");
        }
        /*if(employee.getFirstname()==null)
        {
        	errors.rejectValue("firstname", "id.error");
        }*/
        
    }

	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.isAssignableFrom(clazz);
		
	}
}
	

