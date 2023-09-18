package com.example.demoreactivefsm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Entry {
	private static final Logger logger = LoggerFactory.getLogger(Entry.class);
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Entry.class, args);
		GreetingClient greetingClient = context.getBean(GreetingClient.class);
		// We need to block for the content here or the JVM might exit before the message is logged
		logger.info(">> message = {}", greetingClient.getMessage().block());
	}
}