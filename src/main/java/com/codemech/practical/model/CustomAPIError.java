/**
 * Custom Class for representing  
 * errors in a more concise/readable format.
 *
 * @author  Simran Hotchandani
 * @date 	14/01/23
 * @since   JDK1.8
 */
package com.codemech.practical.model;

import java.util.Date;

public class CustomAPIError {

	private int statusCode;
	private Date timestamp;
	private String message;
	private String description;

	public CustomAPIError(int statusCode, Date timestamp, String message, String description) {
		this.statusCode = statusCode;
		this.timestamp = timestamp;
		this.message = message;
		this.description = description;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}

}
