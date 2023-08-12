package com.example.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class SpringBootJmConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJmConsumerApplication.class, args);
	}

}
