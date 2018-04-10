package com.ncu.TrafficInformationSystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ncu.TrafficInformationSystem.Mapper")
public class TrafficInformationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrafficInformationSystemApplication.class, args);
	}
}
