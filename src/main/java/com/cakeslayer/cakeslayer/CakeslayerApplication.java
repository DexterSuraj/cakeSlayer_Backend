package com.cakeslayer.cakeslayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class CakeslayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CakeslayerApplication.class, args);

	}

	@Bean
	public PlatformTransactionManager addTo(MongoDatabaseFactory bdFactory){
		return new MongoTransactionManager(bdFactory);
	}
}
