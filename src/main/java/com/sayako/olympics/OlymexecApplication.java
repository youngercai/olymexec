package com.sayako.olympics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class OlymexecApplication {

	public static void main(String[] args) {
		SpringApplication sa=new SpringApplication(OlymexecApplication.class);
		// 禁用命令行更改application.properties属性
		sa.setAddCommandLineProperties(false);
		sa.run(args);
	}
}
