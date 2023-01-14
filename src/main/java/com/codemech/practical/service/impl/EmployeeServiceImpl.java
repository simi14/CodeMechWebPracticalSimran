/**
 * Implementation of Employee Service
 *
 * @author  Simran Hotchandani
 * @date 	14/01/23
 * @since   JDK1.8
 */
package com.codemech.practical.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codemech.practical.exception.ResourceNotFoundException;
import com.codemech.practical.model.Designation;
import com.codemech.practical.model.Employee;
import com.codemech.practical.repository.DesignationRepository;
import com.codemech.practical.repository.EmployeeRepository;
import com.codemech.practical.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	// Dependency Injected
	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DesignationRepository designationRepository;

	public ResponseEntity<List<Employee>> getEmployees() {

		// get employees from database
		return new ResponseEntity<>(employeeRepository.findAll(),HttpStatus.OK);
	}

	public ResponseEntity<Employee> saveEmployee(Employee employee) {

		// Insert/update designation
		employee.setDesignation(updateOrSaveDesignation(employee));
		// insert employee
		return new ResponseEntity<>(employeeRepository.save(employee),HttpStatus.CREATED);
	}

	public Designation updateOrSaveDesignation(Employee employee) {
		// check if designation exists
		Optional<Designation> designation = designationRepository
				.findByDesignationName(employee.getDesignation().getDesignationName());

		// return if exists/ create
		if (designation.isPresent()) {
			return designation.get();
		} else {
			return designationRepository.save(employee.getDesignation());
		}
	}

	public ResponseEntity<Employee> updateEmployee(Integer id, Employee employee) {
		// check if employee exists
		Optional<Employee> foundEmployee = employeeRepository.findByEmployeeId(id);

		// update
		if (foundEmployee.isPresent()) {
			employee.setDesignation(updateOrSaveDesignation(employee));
			employee.setEmployeeId(id);
			return new ResponseEntity<>(employeeRepository.save(employee),HttpStatus.OK);
		} else {
			// if employee not found, throw an error
			throw new ResourceNotFoundException("No such Id exists");
		}
	}

	public void deleteEmployee(Integer id) {
		// delete
		employeeRepository.deleteById(id);
	}

	public ResponseEntity<List<Employee>> getEmployeesbyDesignation(String name) {

		// check if designation exists
		Optional<Designation> designation = designationRepository.findByDesignationName(name);

		// return if found/ return exception
		if (designation.isPresent()) {
			return new ResponseEntity<>(employeeRepository.findAllByDesignation(designation.get()),HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("No such Designation Exists");
		}
	}

	public ResponseEntity<List<Employee>> findEmployeesOrderBySalary(Integer orderParameter) {
		// if positive, sort in ascending order
		if (orderParameter >= 0) {
			return new ResponseEntity<>(employeeRepository.findAllByOrderBySalaryAsc(),HttpStatus.OK);
		}
		// if negative, sort in descending order
		else {
			return new ResponseEntity<>(employeeRepository.findAllByOrderBySalaryDesc(),HttpStatus.OK);
		}
	}
}
