package com.pse.testserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.pse.testserver"})
@SpringBootApplication
@EnableAutoConfiguration
public class TestServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestServerApplication.class, args);
	}
}
