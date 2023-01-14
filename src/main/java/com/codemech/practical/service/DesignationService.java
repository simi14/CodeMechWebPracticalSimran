/**
 * service layer Designation
 *
 * @author  Simran Hotchandani
 * @date 	14/01/23
 * @since   JDK1.8
 */
package com.codemech.practical.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.codemech.practical.model.Designation;

public interface DesignationService {

	// find all designations
	public ResponseEntity<List<Designation>> getDesignations();

	// insert designation
	public ResponseEntity<Designation> saveDesignation(Designation designation);

	// update designation
	public ResponseEntity<Designation> updateDesignation(Integer id, Designation designation);

	// delete designation
	public void deleteDesignation(Integer id);
}
