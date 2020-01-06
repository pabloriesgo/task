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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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

	/**
	 * List all existing tasks
	 * 
	 * @return list of all existing tasks embedded in objects of type
	 *         <code>Task</code>
	 */
	@GetMapping("/tasks")
	@ApiOperation(value = "Find all tasks", notes = "Retrieving the collection of all tasks", response = Task[].class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Success", response = Task[].class) })
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
	@ApiOperation(value = "Find one task", notes = "Retrieving one task", response = Task.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Success", response = Task.class),
			@ApiResponse(code = 404, message = "Not found") })
	public Task findById(
			@ApiParam(required = true, name = "id", value = "ID of the task you want to find") @PathVariable Integer id) {
		return taskService.findById(id);
	}

	/**
	 * Create a new task
	 * 
	 * @param task container of task data
	 * @return data of the created task
	 */
	@PostMapping("/tasks")
	@ApiOperation(value = "Create a new task", notes = "Creating a new task", response = Task.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Success", response = Task.class) })
	public Task createTask(@ApiParam(required = true, name = "task", value = "Task to create") @RequestBody Task task) {
		return taskService.createTask(task);
	}

	/**
	 * Mark a task as finished
	 * 
	 * @param id identifier of the task to mark
	 * @return data of the modified task
	 */
	@PostMapping("/tasks/{id}/finish")
	@ApiOperation(value = "Mark a task as finished", notes = "Finishing a task", response = Task.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Success", response = Task.class),
			@ApiResponse(code = 404, message = "Not found") })
	public Task finishTask(
			@ApiParam(required = true, name = "id", value = "ID of the task you want to finish") @PathVariable Integer id) {
		return taskService.finishTask(id);
	}

	/**
	 * Remove a task
	 * 
	 * @param id identifier of the task to remove
	 */
	@DeleteMapping("/tasks/{id}")
	@ApiOperation(value = "Remove an existing task", notes = "Removing a task", response = Task.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Success", response = Task.class),
			@ApiResponse(code = 404, message = "Not found") })
	public void deleteTask(
			@ApiParam(required = true, name = "id", value = "ID of the task you want to remove") @PathVariable Integer id) {
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
	@ApiOperation(value = "Update an existing task", notes = "Updating an existing task", response = Task.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Success", response = Task.class),
			@ApiResponse(code = 404, message = "Not found") })
	public Task updateTask(@ApiParam(required = true, name = "task", value = "Updated task") @RequestBody Task newTask,
			@ApiParam(required = true, name = "id", value = "ID of the task you want to update") @PathVariable Integer id) {
		return taskService.updateTask(newTask, id);
	}

}
