package com.scaler.bookmyshowjune2023;

import com.scaler.bookmyshowjune2023.controllers.UserController;
import com.scaler.bookmyshowjune2023.dtos.SignupUserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Bookmyshowjune2023Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Bookmyshowjune2023Application.class, args);
	}
	UserController userController;
	@Autowired
	public Bookmyshowjune2023Application(UserController userController){
		this.userController=userController;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hello");
		SignupUserRequestDto requestDto =new SignupUserRequestDto();
		requestDto.setEmail("tiwariankit487@gmail.com");
		requestDto.setPassword("password");
		userController.signupUserResponseDto(requestDto);
	}
}
