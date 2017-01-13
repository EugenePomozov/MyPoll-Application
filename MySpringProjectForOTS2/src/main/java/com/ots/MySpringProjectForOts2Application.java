package com.ots;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class MySpringProjectForOts2Application {

	public static void main(String[] args) {
		SpringApplication.run(MySpringProjectForOts2Application.class, args);
	}
}
