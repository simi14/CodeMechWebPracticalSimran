/**
 * Model created for Designation Table
 *
 * @author  Simran Hotchandani
 * @date 	14/01/23
 * @since   JDK1.8
 */
package com.codemech.practical.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
//Table Name by default Created: Designation
public class Designation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="designation_id")
	private Integer designationId;
	
	@Column(name="designation_name")
	@NotBlank(message = "Please mention the designation")
	@NotEmpty(message="Please mention the designation")
	private String designationName;

	//setters, getters
	
	public Integer getDesignationId() {
		return designationId;
	}

	public void setDesignationId(Integer designationId) {
		this.designationId = designationId;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}
	
	
}
