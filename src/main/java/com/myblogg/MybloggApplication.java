package com.myblogg;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MybloggApplication {

	public static void main(String[] args) {

		SpringApplication.run(MybloggApplication.class, args);
	}
	@Bean
	public ModelMapper fetModelMapper(){

		return new ModelMapper();
	}
//	@Bean
//	PasswordEncoder passwordEncoder(){
//		return  new BCryptPasswordEncoder();
//	}

}
