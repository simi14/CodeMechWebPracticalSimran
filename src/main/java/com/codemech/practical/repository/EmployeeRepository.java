/**
 * Repository class extending JPA Repository
 * for handling all Employee related 
 * database operations.
 *
 * @author  Simran Hotchandani
 * @date 	14/01/23
 * @since   JDK1.8
 */
package com.codemech.practical.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codemech.practical.model.Designation;
import com.codemech.practical.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	//find employee by id
	Optional<Employee> findByEmployeeId(Integer id);
	
	//find by designation
	List<Employee> findAllByDesignation(Designation designation);
	
	//sort by salary ascending
	List<Employee> findAllByOrderBySalaryAsc();
	
	//sort by salary descending
	List<Employee> findAllByOrderBySalaryDesc(); 
}
