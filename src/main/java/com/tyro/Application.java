package com.tyro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.tyro.db.DevDBProperties;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableConfigurationProperties({ DataSourceProperties.class, DevDBProperties.class })
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
