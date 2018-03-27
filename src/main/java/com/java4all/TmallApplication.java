package com.java4all;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableAutoConfiguration
@RestController
public class TmallApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmallApplication.class, args);
	}

	@RequestMapping(value = "login",method = RequestMethod.GET)
	public String login(){
		return "欢迎登陆:"+ LocalDateTime.now();
	}
}
