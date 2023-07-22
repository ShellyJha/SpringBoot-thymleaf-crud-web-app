package net.javaguides.springbootthymleafcrudwebapp.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springbootthymleafcrudwebapp.model.Employee;
import net.javaguides.springbootthymleafcrudwebapp.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {
//inject employee repository using Autowired annotation
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public List<Employee> getAllEmployees() {
		// return list of employee to controller
		return employeeRepository.findAll();
	}
	@Override
	public void saveEmployee(Employee employee) {
		// save the employee
		this.employeeRepository.save(employee);
	}
	
	//below method will be called from the controller
	@Override
	public Employee getEmployeeById(long id) {
		// update the employee. find by id basically return optional object 
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if(optional.isPresent())
		{
			employee = optional.get();
		}
		else
		{
			throw new RuntimeException("Employee not found for id:: " + id);
		}
		return employee;
	}
	@Override
	public void deleteEmployeebyId(long id) {
		// TODO Auto-generated method stub
		this.employeeRepository.deleteById(id);
	}

}
