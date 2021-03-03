package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JegoopaysApplication {

	public static void main(String[] args) {
		SpringApplication.run(JegoopaysApplication.class, args);
	}
// cd frontend/ && npm run build && cd .. && mkdir -p src/main/resources/static && cp -r frontend/build/* src/main/resources/static && mvn install

}
