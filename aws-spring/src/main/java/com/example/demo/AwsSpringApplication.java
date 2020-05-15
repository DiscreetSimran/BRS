package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.demo.config")
@ComponentScan("com.example.demo.controller")
public class AwsSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsSpringApplication.class, args);
	}

}
