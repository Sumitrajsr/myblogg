package com.myblogg;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MybloggApplication {

	public static void main(String[] args) {

		SpringApplication.run(MybloggApplication.class, args);
	}
	@Bean
	public ModelMapper fetModelMapper(){
		return new ModelMapper();
	}

}
