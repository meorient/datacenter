package com.meorient.synchro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ServletComponentScan
@ComponentScan(basePackages = { "com.meorient" })
public class SynchroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SynchroApplication.class, args);
	}
}
