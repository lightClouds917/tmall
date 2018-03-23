package com.java4all;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
@RestController
public class TmallApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmallApplication.class, args);
	}
	@RequestMapping(value = "test1",method = RequestMethod.GET)
	public String test1(){
		return "欢迎登陆"+ LocalDate.now()+" "+LocalTime.now();
	}
}
