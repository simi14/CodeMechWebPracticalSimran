/**
 * This class acts as entry point  
 * for all Employee related api operations.
 *
 * @author  Simran Hotchandani
 * @date 	14/01/23
 * @since   JDK1.8
 */
package com.codemech.practical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codemech.practical.model.Employee;
import com.codemech.practical.service.DesignationService;
import com.codemech.practical.service.EmployeeService;

@RestController
public class EmployeeController {

	// Dependency Injected
	@Autowired
	EmployeeService employeeService;

	@Autowired
	DesignationService designationService;

	@GetMapping(value = "/employee")
	public ResponseEntity<List<Employee>> getEmployees() {
		// list all employees
		return employeeService.getEmployees();
	}

	@PostMapping(value = "/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		// insert
		return employeeService.saveEmployee(employee);
	}

	@PutMapping(value = "/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
		// update
		return employeeService.updateEmployee(id, employee);
	}

	@DeleteMapping(value = "/employee/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
		// delete
		employeeService.deleteEmployee(id);
	}

	@GetMapping(value = "getEmployeesbyDesignation/{name}")
	public ResponseEntity<List<Employee>> getEmployeesbyDesignation(@PathVariable String name) {
		// employees by designation
		return employeeService.getEmployeesbyDesignation(name);
	}

	@GetMapping(value = "orderEmployeesBySalary/{orderParameter}")
	public ResponseEntity<List<Employee>> findEmployeesOrderBySalary(@PathVariable Integer orderParameter) {
		// employee order by salary
		return employeeService.findEmployeesOrderBySalary(orderParameter);
	}

}