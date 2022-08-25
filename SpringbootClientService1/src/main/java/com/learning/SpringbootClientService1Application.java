package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootClientService1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootClientService1Application.class, args);
	}

}
