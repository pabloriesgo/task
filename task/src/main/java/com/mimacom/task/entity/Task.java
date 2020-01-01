/**
 * 
 */
package com.mimacom.task.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * Entity to store task information
 * 
 * @author priesgo
 *
 */
@Data
@Entity
public class Task {

	private @Id @GeneratedValue Integer id;
	private String name;
	private String description;
	private Boolean isFinished;
	
	public Task () {}
	
	public Task (String name, String description, Boolean isFinished){
		this.name = name;
		this.description = description;
		this.isFinished = isFinished;
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the isFinished
	 */
	public Boolean getIsFinished() {
		return isFinished;
	}
	/**
	 * @param isFinished the isFinished to set
	 */
	public void setIsFinished(Boolean isFinished) {
		this.isFinished = isFinished;
	}
}
