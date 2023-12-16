package com.unittesting;

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UnitTestingDemoProjectUserManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitTestingDemoProjectUserManagementApplication.class, args);
		
		System.out.println("Application is running fine...");
	}

}
