/**
 * 
 */
package com.mimacom.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a task does not exist
 * 
 * @author priesgo
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class TaskNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7898910422675010741L;

	private Integer id;
	
	/**
	 * Constructor from a task identifier
	 * 
	 * @param id task identifier
	 */
	public TaskNotFoundException(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public String getMessage() {
		StringBuilder message = new StringBuilder();
		message.append("Could not find task ");
		message.append(id);
		return message.toString();
	}
}
