package com.example.newdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.example.newdemo.mapper")
public class NewdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewdemoApplication.class, args);
	}

}
