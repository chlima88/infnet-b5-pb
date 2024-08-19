package com.chlima.tp1project;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(title = "E-Commerce API", description = "E-Commerce API Documentation")
)
public class Tp1ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tp1ProjectApplication.class, args);
	}

}
