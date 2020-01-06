/**
 * 
 */
package com.mimacom.task.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mimacom.task.entity.Task;
import com.mimacom.task.exception.TaskNotFoundException;
import com.mimacom.task.repository.TaskRepository;
import com.mimacom.task.service.TaskService;

/**
 * Implementation of the service to handle task operations
 * 
 * @author priesgo
 *
 */
@Service
@Transactional
public class TaskServiceImpl implements TaskService {

	private final TaskRepository taskRepository;

	public TaskServiceImpl(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@Override
	public List<Task> findAll() {
		return taskRepository.findAll();
	}

	@Override
	public Task findById(Integer id) {
		return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
	}

	@Override
	public Task createTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public Task finishTask(Integer id) {
		Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
		task.setIsFinished(Boolean.TRUE);
		return taskRepository.save(task);
	}

	@Override
	public void deleteTask(Integer id) {
		taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
		taskRepository.deleteById(id);
	}

	@Override
	public Task updateTask(Task newTask, Integer id) {
		return taskRepository.findById(id).map(task -> {
			task.setName(newTask.getName());
			task.setDescription(newTask.getDescription());
			task.setIsFinished(newTask.getIsFinished());
			return taskRepository.save(task);
		}).orElseThrow(() -> new TaskNotFoundException(id));
	}

}
