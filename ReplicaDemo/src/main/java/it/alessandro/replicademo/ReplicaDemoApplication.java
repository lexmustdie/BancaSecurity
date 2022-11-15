package it.alessandro.replicademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //Bean che comprende @ComponentScan, @EnableAutoConfiguration e @Configuration
public class ReplicaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReplicaDemoApplication.class, args);
	}

}
