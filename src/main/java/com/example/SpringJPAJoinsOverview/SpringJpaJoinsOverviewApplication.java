package com.example.SpringJPAJoinsOverview;

import com.example.SpringJPAJoinsOverview.service.ProcessJoins;
import org.hibernate.HibernateException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJpaJoinsOverviewApplication {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext applicationContext = SpringApplication.run(SpringJpaJoinsOverviewApplication.class, args);
		ProcessJoins processJoins = applicationContext.getBean(ProcessJoins.class);
		processJoins.loadDataInTables();
//		Thread.sleep(3000000);
//		HibernateException
	}

}
