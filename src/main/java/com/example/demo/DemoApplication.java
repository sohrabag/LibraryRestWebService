package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This program allow the user to access a library archiving system
 * this is a spring mvc web service. it is coded in JAVA 8 and all the
 * controllers are RestController which makes it very advance. this is
 * spring boot, spring JPA DATA, maven, JPARepository which supports
 * JPQL and native SQL.
 * Spring annotation is used extensively to facilitate a reconfigurable
 * software, everything is object oriented and we have business layer, 
 * controller layer, data access layer, gui layer
 * server can serve any sort of front end which can connect to a Rest API 
 * controller.
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
