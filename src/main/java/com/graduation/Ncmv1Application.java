package com.graduation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.graduation.mapper")
public class Ncmv1Application {

	
	public static void main(String[] args) {
		SpringApplication.run(Ncmv1Application.class, args);
	}

}
