/**
 * 
 */
package com.mimacom.task.service;

import java.util.List;

import com.mimacom.task.entity.Task;

/**
 * Service to handle task operations
 * 
 * @author priesgo
 *
 */
public interface TaskService {

	/**
	 * Gets all existing tasks
	 * 
	 * @return all existing tasks stored in a list of <code>Task</code> objects
	 */
	List<Task> findAll();

	/**
	 * Finds a task from its identifier
	 * 
	 * @param id identifier of the task to find
	 * @return task found
	 */
	Task findById(Integer id) ;

	/**
	 * Create a task
	 * 
	 * @param task task to create
	 * @return task created
	 */
	Task createTask(Task task);

	/**
	 * Mark a task as finished
	 * 
	 * @param id identifier of the task to mark as finished
	 * @return task marked as finished
	 */
	Task finishTask(Integer id) ;

	/**
	 * Removes a task
	 * 
	 * @param id identifier of the task to remove
	 */
	void deleteTask(Integer id);

	/**
	 * Updates a task
	 * 
	 * @param newTask data of the task to be updated
	 * @param id      identifier of the task
	 * @return task updated
	 */
	Task updateTask(Task newTask, Integer id);

}
