package com.luv2code.sprintboot.demo.mycoolapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* @SpringBootApplication(
		scanBasePackages = {"com.luv2code.sprintboot.demo.mycoolapp", "com.luv2code.util"}
) */
@SpringBootApplication
public class MycoolappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}

}
