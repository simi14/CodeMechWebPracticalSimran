/**
 * service layer Employee
 *
 * @author  Simran Hotchandani
 * @date 	14/01/23
 * @since   JDK1.8
 */
package com.codemech.practical.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.codemech.practical.model.Employee;

public interface EmployeeService {

	// list all employees
	public ResponseEntity<List<Employee>> getEmployees();

	// insert employee
	public ResponseEntity<Employee> saveEmployee(Employee employee);

	// update Employee
	public ResponseEntity<Employee> updateEmployee(Integer id, Employee employee);

	// Delete Employee
	public void deleteEmployee(Integer id);

	// List Employees By designation
	public ResponseEntity<List<Employee>> getEmployeesbyDesignation(String name);

	// sort employees based on salary
	// positive parameter sorts in ascending/ negative parameter sorts in descending
	public ResponseEntity<List<Employee>> findEmployeesOrderBySalary(Integer orderParameter);
}
