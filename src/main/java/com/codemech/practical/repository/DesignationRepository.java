/**
 * Repository class extending JPA Repository
 * for handling all Designation related 
 * database operations.
 *
 * @author  Simran Hotchandani
 * @date 	14/01/23
 * @since   JDK1.8
 */
package com.codemech.practical.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codemech.practical.model.Designation;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Integer>{
 
	//find by Id
	public Optional<Designation> findBydesignationId(Integer id);
	
	//find by designation name
	public Optional<Designation> findByDesignationName(String name);
}
