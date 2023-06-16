package com.proyectoTFG.PoyectoTFG;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@EnableJpaRepositories
public class PoyectoTfgApplication {


	public static void main(String[] args) {
		SpringApplication.run(PoyectoTfgApplication.class, args);
		
	}
}
