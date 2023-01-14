/**
 * This class acts as controller advice
 * for all exception handling.
 *
 * @author  Simran Hotchandani
 * @date 	14/01/23
 * @since   JDK1.8
 */
package com.codemech.practical.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.codemech.practical.model.CustomAPIError;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<CustomAPIError> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		CustomAPIError message = new CustomAPIError(HttpStatus.NOT_FOUND.value(), new Date(), ex.getMessage(),request.getDescription(false));

		return new ResponseEntity<CustomAPIError>(message, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomAPIError> globalExceptionHandler(Exception ex, WebRequest request) {
		CustomAPIError message = new CustomAPIError(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(),ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<CustomAPIError>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
