package com.example.exDBTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ExDbTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExDbTestApplication.class, args);
	}

}
