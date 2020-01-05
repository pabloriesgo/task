/**
 * 
 */
package com.mimacom.task.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mimacom.task.entity.Task;
import com.mimacom.task.service.TaskService;

/**
 * Controller to handle requests to task API
 * 
 * @author priesgo
 *
 */
@RestController
public class TaskController {

	private final TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	// TODO --> Sacar negocio a jar y ver como hacer esto multimódulo

	// TODO --> JAVADOC de todo --> REVISAR SWAGGER

	// TODO --> HAcaer mensajes de error HTTP para respuestas de error guays

	// TODO --> Nombre único

	/**
	 * List all existing tasks
	 * 
	 * @return list of all existing tasks embedded in objects of type
	 *         <code>Task</code>
	 */
	@GetMapping("/tasks")
	public List<Task> findAll() {
		return taskService.findAll();
	}

	/**
	 * Retrieve a task from its identifier
	 * 
	 * @param id identifier of the task to retrieve
	 * @return task found or throws a <code>TaskNotFoundException</code> if it does
	 *         not exist
	 */
	@GetMapping("/tasks/{id}")
	public Task findById(@PathVariable Integer id) {
		return taskService.findById(id);
	}

	/**
	 * Create a new task
	 * 
	 * @param task container of task data
	 * @return data of the created task
	 */
	@PostMapping("/tasks")
	public Task createTask(@RequestBody Task task) {
		return taskService.createTask(task);
	}

	/**
	 * Mark a task as finished
	 * 
	 * @param id identifier of the task to mark
	 * @return data of the modified task
	 */
	@PostMapping("/tasks/{id}/finish")
	public Task finishTask(@PathVariable Integer id) {
		return taskService.finishTask(id);
	}

	/**
	 * Remove a task
	 * 
	 * @param id identifier of the task to remove
	 */
	@DeleteMapping("/tasks/{id}")
	public void deleteTask(@PathVariable Integer id) {
		taskService.deleteTask(id);
	}

	/**
	 * Update a task. If it does not exist, create a new task with the given data.
	 * 
	 * @param newTask data to modify of the task
	 * @param id      identifier of the task to modify
	 * @return data updated or created
	 */
	@PutMapping("/tasks/{id}")
	public Task updateTask(@RequestBody Task newTask, @PathVariable Integer id) {
		return taskService.updateTask(newTask, id);
	}

}
