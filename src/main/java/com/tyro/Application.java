package com.tyro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.tyro.config.db.DevDBProperties;
import com.tyro.config.db.TestDBProperties;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages="com.tyro")
@EnableConfigurationProperties({ DataSourceProperties.class, DevDBProperties.class, TestDBProperties.class })
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
