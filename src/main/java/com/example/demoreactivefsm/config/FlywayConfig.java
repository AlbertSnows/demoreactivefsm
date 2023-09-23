//package com.example.demoreactivefsm.config;
//
//import org.flywaydb.core.Flyway;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//
//// https://stackoverflow.com/a/61412233
//@Configuration
//public class FlywayConfig {
//
//	private final Environment env;
//
//	@Autowired
//	public FlywayConfig(final Environment env) {
//		this.env = env;
//	}
//
//	@Bean(initMethod = "migrate")
//	public Flyway flyway() {
//		var url = env.getRequiredProperty("spring.flyway.url");
//		var user = env.getRequiredProperty("spring.flyway.user");
//		var password = env.getRequiredProperty("spring.flyway.password");
//		var flywayConfig = Flyway.configure()
//						.baselineOnMigrate(true)
//						.dataSource(url, user, password);
//		return new Flyway(flywayConfig);
//	}
//}