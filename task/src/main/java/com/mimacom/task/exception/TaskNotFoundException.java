/**
 * 
 */
package com.mimacom.task.exception;

/**
 * Exception thrown when a task does not exist
 * 
 * @author priesgo
 *
 */
public class TaskNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7898910422675010741L;

	public TaskNotFoundException(Integer id) {
		//TODO -> Construir bien mensaje
		super("Could not find task " + id);
	}
	
}
