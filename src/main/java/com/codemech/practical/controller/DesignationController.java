/**
 * This class acts as entry point  
 * for all Designation related api operations.
 *
 * @author  Simran Hotchandani
 * @date 	14/01/23
 * @since   JDK1.8
 */
package com.codemech.practical.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codemech.practical.model.Designation;
import com.codemech.practical.service.DesignationService;
import com.codemech.practical.service.EmployeeService;

@RestController
public class DesignationController {

	// dependency injected

	@Autowired
	EmployeeService employeeService;

	@Autowired
	DesignationService designationService;

	// get
	@GetMapping(value = "/designation")
	public ResponseEntity<List<Designation>> getDesignations() {
		return designationService.getDesignations();
	}

	// insert
	@PostMapping(value = "/designation")
	public ResponseEntity<Designation> saveDesignation(@Valid @RequestBody Designation designation) {
		return designationService.saveDesignation(designation);
	}

	// update
	@PutMapping(value = "/designation/{id}")
	public ResponseEntity<Designation> updateDesignation(@PathVariable Integer id,
			@RequestBody Designation designation) {
		return designationService.updateDesignation(id, designation);
	}

	// delete
	@DeleteMapping(value = "/designation/{id}")
	public void deleteDesignation(@PathVariable Integer id) {
		designationService.deleteDesignation(id);
	}
}
