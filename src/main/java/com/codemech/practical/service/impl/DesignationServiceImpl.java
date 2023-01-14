/**
 * Implementation of Designation Service
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
import com.codemech.practical.service.DesignationService;

@Service
@Transactional
public class DesignationServiceImpl implements DesignationService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DesignationRepository designationRepository;

	public ResponseEntity<List<Designation>> getDesignations() {
		// find all from database
		return new ResponseEntity<>(designationRepository.findAll(),HttpStatus.OK);
	}

	public ResponseEntity<Designation> saveDesignation(Designation designation) {
		// insert into database
		Designation existingDesignation=checkIfDesignationExists(designation.getDesignationName());
		if(existingDesignation==null) {
		return new ResponseEntity<>(designationRepository.save(designation),HttpStatus.CREATED);}
		return new ResponseEntity<>(existingDesignation,HttpStatus.OK);
	}

	public ResponseEntity<Designation> updateDesignation(Integer id, Designation designation) {

		// Check if designation exists
		Designation existingDesignation=checkIfDesignationExists(id);

		// update
		if (existingDesignation!=null) {
			designation.setDesignationId(id);
			return new ResponseEntity<>(designationRepository.save(designation),HttpStatus.CREATED);
		}

		// else throw error
		else {
			throw new ResourceNotFoundException("No such Id exists");
		}
	}

	public void deleteDesignation(Integer id) {

		// Check if designation exists
		Optional<Designation> designation = designationRepository.findBydesignationId(id);

		// first delete all Employee's associated with this designation
		if (designation.isPresent()) {
			List<Employee> employeeList = employeeRepository.findAllByDesignation(designation.get());
			for (Employee employee : employeeList) {
				employeeRepository.delete(employee);
			}

			// delete the designation
			designationRepository.deleteById(id);
		}
	}
	
	//Checks if designation exists Id given
	public Designation checkIfDesignationExists(Integer id) {
		Optional<Designation> designation = designationRepository.findBydesignationId(id);
		if(designation.isPresent()) {
			return designation.get();
		}
		return null;
	}
	
	//Checks if designation exists name given
	public Designation checkIfDesignationExists(String name) {
		Optional<Designation> designation = designationRepository.findByDesignationName(name);
		if(designation.isPresent()) {
			return designation.get();
		}
		return null;
	}
}
