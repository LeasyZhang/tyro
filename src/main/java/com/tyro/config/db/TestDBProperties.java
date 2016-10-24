package com.tyro.config.db;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Profile;

@ConfigurationProperties("spring.test")
@Profile("test")
public class TestDBProperties {

	@NestedConfigurationProperty
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
