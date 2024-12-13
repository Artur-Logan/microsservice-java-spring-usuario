package com.arturlogan.ms.user;

import com.arturlogan.ms.user.entities.Usuario;
import com.rabbitmq.tools.json.JSONUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
		System.out.println("Hello World!!!");
	}

}
