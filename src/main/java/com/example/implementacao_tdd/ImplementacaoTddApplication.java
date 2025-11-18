package com.example.implementacao_tdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class ImplementacaoTddApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImplementacaoTddApplication.class, args);
	}
	
	@RequestMapping ("/")
	@ResponseBody
	String home() {
		return "Hello World";
	}

}
