package com.bma.directory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.bma.directory")
public class StudentDirectoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentDirectoryApplication.class, args);
	}

}
