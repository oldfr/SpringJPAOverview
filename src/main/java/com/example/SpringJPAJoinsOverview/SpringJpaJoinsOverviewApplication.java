package com.example.SpringJPAJoinsOverview;

import com.example.SpringJPAJoinsOverview.service.ProcessJoins;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJpaJoinsOverviewApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringJpaJoinsOverviewApplication.class, args);
		ProcessJoins processJoins = applicationContext.getBean(ProcessJoins.class);
		processJoins.processData();
	}

}
