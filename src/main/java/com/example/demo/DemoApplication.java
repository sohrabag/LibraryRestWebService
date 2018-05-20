package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <h1>DemoApplication WebService</h1>
 * DemoApplication exposes a library archiving system.
 * this is a spring mvc web service. it is implemented in JAVA 8 and supports spring DATA JPA 
 * access. All the controllers are Rest. 
 * <p>
 * This is spring boot, spring JPA DATA, maven, JPARepository which supports
 * JPQL and native SQL.
 * Spring annotation is used extensively to facilitate a reconfigurable
 * software, everything is object oriented and we have business layer, 
 * controller layer, data access layer, gui layer
 * server can serve any sort of front end which can connect to a Rest API 
 * controller.
 * </p>
 * 
 * @author Sohrab Azami Ghadim
 * @version 1.0
 * @since 2018-05-10
 *
 */
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
