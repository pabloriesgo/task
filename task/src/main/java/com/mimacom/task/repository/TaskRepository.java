/**
 * 
 */
package com.mimacom.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mimacom.task.entity.Task;

/**
 * @author priesgo
 *
 */
public interface TaskRepository extends JpaRepository<Task, Integer>{

}
