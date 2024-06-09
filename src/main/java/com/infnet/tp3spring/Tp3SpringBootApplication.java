package com.infnet.tp3spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Tp3SpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tp3SpringBootApplication.class, args);
	}

}
