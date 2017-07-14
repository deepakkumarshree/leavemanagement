package com.lms.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lms.model.Employee;
import com.lms.service.EmployeeService;
import com.lms.service.LoginService;
import com.lms.validator.EmployeeValidator;



@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeValidator empValidator;
	
	@Autowired
	private MessageSource message;
	
	 @RequestMapping({"login"})
	  public ModelAndView login() throws Exception
	  {
	    ModelAndView modelandview = null;
	    modelandview = new ModelAndView("login", "logincommand", new Employee());
	    System.out.println("Controller :LoginController Method :showLogin");
	    return modelandview;
	  }
	@RequestMapping({"/validateUser"})
	  public ModelAndView validateUser(HttpServletRequest request, @ModelAttribute("logincommand") Employee emp)
	    throws Exception
	  {
	    ModelAndView modelandview = null;
	    modelandview = new ModelAndView("Logintiles");
	    System.out.println("Controller :LoginController Method :showLogin");
	    boolean status = loginService.isValidUser(emp, request);
	    
	    modelandview = new ModelAndView("redirect:login", "status", Boolean.valueOf(status));
	    return modelandview;
	  }
	
	@RequestMapping("/addEmployee")
	public ModelAndView addEmployee(@ModelAttribute("empBean")Employee employee)
	{
	
	   return new ModelAndView("addemp");
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@Valid @ModelAttribute("empBean")Employee employee, BindingResult result)
	{
	  empValidator.validate(employee, result);
		
		if (result.hasErrors()) {
			return new ModelAndView("addemp");
		}
		employeeService.addEmployee(employee);
		return new ModelAndView("saveemp");
		
	}

}
