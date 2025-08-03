package com.SpringData.DataProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class DataProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataProjectApplication.class, args);
	}

}
