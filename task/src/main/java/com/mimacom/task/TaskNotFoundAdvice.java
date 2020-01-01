/**
 * 
 */
package com.mimacom.task;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mimacom.task.exception.TaskNotFoundException;

/**
 * @author priesgo
 *
 */
@ControllerAdvice
public class TaskNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(TaskNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String taskNotFoundHandler(TaskNotFoundException ex) {
		return ex.getMessage();
	}

}
