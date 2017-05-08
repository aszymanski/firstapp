package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@EnableAutoConfiguration
@SpringBootApplication
public class RestStarterApplication {

	private static final Logger logger = LoggerFactory.getLogger(RestStarterApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestStarterApplication.class, args);
	}

}
