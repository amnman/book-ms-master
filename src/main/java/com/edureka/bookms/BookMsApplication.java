package com.edureka.bookms;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BookMsApplication {

	public static void main(String[] args) {

		new SpringApplicationBuilder()
		.profiles("DEV")
		.sources(BookMsApplication.class)
		.run(args);
	}
}
