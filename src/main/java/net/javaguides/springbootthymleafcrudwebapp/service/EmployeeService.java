package net.javaguides.springbootthymleafcrudwebapp.service;

import java.util.List;

import net.javaguides.springbootthymleafcrudwebapp.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();

	void saveEmployee(Employee employee);

	Employee getEmployeeById(long id);
	
	void deleteEmployeebyId(long id);
}
