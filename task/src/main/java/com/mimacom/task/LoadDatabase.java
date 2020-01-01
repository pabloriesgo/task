/**
 * 
 */
package com.mimacom.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mimacom.task.entity.Task;
import com.mimacom.task.repository.TaskRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author priesgo
 *
 */
@Configuration
@Slf4j
public class LoadDatabase {

	@Bean
	  CommandLineRunner initDatabase(TaskRepository repository) {
	    return args -> {
	      log.info("Preloading " + repository.save(new Task("Ironing", "Do the ironing", Boolean.FALSE)));
	      log.info("Preloading " + repository.save(new Task("Shopping", "Go shopping to buy socks", Boolean.FALSE)));
	    };
	  }
	
}
