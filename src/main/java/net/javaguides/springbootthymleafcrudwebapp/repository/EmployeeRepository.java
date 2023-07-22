package net.javaguides.springbootthymleafcrudwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springbootthymleafcrudwebapp.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
