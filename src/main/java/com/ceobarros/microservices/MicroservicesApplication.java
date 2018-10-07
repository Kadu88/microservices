package com.ceobarros.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class MicroservicesApplication {

	@RequestMapping("/")
	@ResponseBody
	String ola(){
		return "Olá, bem vindo ao sistema do Carlão!";
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesApplication.class, args);
	}



}
