package com.example.dlocal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DlocalApplication {

	/**
	 * Starter of the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(DlocalApplication.class, args);
	}
}
