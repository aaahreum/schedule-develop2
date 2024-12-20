package com.example.scheduleproject3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ScheduleProject3Application {

	public static void main(String[] args) {
		SpringApplication.run(ScheduleProject3Application.class, args);
	}

}
