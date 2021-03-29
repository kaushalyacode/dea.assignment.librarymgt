package com.example.demo;

import com.example.demo.Data.Dao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
		System.out.println("hello world");
		Dao data = new Dao();
		data.Connection();
	}

}
