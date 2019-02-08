package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataIoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataIoApplication.class, args);
		System.out.println("Spring Boot Started!! => DataIoApplication");
	}

}

