package com.travle.dreamsky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@ServletComponentScan
@SpringBootApplication() //exclude = {RedisConfig.class}
@RestController
public class DreamskyApplication {

	@RequestMapping("/hello")
	public String sayHello() {
		return "hello world!";
	}

	@RequestMapping("/testgit")
	public String testgit() {
		return "hello github!";
	}

	public static void main(String[] args) {
		SpringApplication.run(DreamskyApplication.class, args);
	}
}
