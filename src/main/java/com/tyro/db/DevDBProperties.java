package com.tyro.db;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Profile;

@ConfigurationProperties("spring.dev")
@Profile("dev")
public class DevDBProperties {

	@NestedConfigurationProperty
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
