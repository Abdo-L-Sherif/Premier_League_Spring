package com.fantasy.PrimierLeague;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}, scanBasePackages = "com.fantasy.PrimierLeague")
@EnableJpaRepositories(basePackages = "com.fantasy.PrimierLeague.player")
@EnableAutoConfiguration
public class PrimierLeagueApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimierLeagueApplication.class, args);
	}

}
