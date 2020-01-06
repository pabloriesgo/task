/**
 * 
 */
package com.mimacom.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger class configuration
 * 
 * @author priesgo
 *
 */
@Configuration
@EnableSwagger2
public class TaskConfig {

	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                         
          .apis(RequestHandlerSelectors.any())
          .paths(PathSelectors.any())       
          .build().apiInfo(apiInfo());                                           
    }
	
	/**
	 * Builds the api information
	 * 
	 * @return api information
	 */
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Simple task API")
                .description("API for managing a custom task list")
                .version("1.0")
                .build();
    }
}
