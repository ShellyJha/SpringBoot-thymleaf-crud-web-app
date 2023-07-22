package net.javaguides.springbootthymleafcrudwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.springbootthymleafcrudwebapp.model.Employee;
import net.javaguides.springbootthymleafcrudwebapp.service.EmployeeService;

@Controller
public class EmployeeController {
//springboot auto configure view resolver for thymleaf as soon as they see the thymleaf dependency in pom.xml and by default it will pock from  templates folder
	@Autowired
	private EmployeeService employeeService;
	// create a method handler which will display the list of all the employees
	// as we have to pass list of employeeds here so we have implemented model

	@GetMapping("/")
	public String viewHomePage(Model model) {
		// adding all the list of attributes to the model

		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "index"; // return the thymleaf template file

	}

	// this request comes from index.html page

	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		// create model attribute to bind form data
		Employee employee = new Employee();
		// thymleaf template will access this empty employee object for binding form
		// data
		model.addAttribute("employee", employee);
		return "new_employee";

	}

	// it will come from new_employee.html , handle form data
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		// save employee to db
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	//this id will come from index.html
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value = "id") long id ,Model  model) {
		//get employee from the service 
		Employee employee = employeeService.getEmployeeById(id);
		
		
		//set employee as a model attribute to pre populate the for, 
		model.addAttribute("employee",employee);
		return "update_employee";
		
	}
	
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value = "id") long id ,Model  model)
	{  // call delete employee method 
		this.employeeService.deleteEmployeebyId(id);
		return "redirect:/";
		
	}

}
