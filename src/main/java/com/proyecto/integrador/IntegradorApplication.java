package com.proyecto.integrador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class IntegradorApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().load();
		System.setProperty("DBPASS", dotenv.get("DBPASS"));
		System.setProperty("USERDB", dotenv.get("USERDB"));
		SpringApplication.run(IntegradorApplication.class, args);
	}

}
