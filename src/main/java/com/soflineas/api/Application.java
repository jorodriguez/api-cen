package com.soflineas.api;


import com.soflineas.api.base.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// principal https://github.com/bezkoder/spring-boot-data-jpa-mysql
//https://www.bezkoder.com/spring-boot-jwt-authentication/

//otro ejemplo : https://github.com/bezkoder/spring-boot-spring-security-jwt-authentication.git

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
