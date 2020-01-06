/**
 * 
 */
package com.mimacom.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mimacom.task.entity.Task;

/**
 * Repository to handle task operations
 * 
 * @author priesgo
 *
 */
public interface TaskRepository extends JpaRepository<Task, Integer>{

}
