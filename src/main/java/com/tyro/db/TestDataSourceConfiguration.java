package com.tyro.db;

import java.util.Optional;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
@MapperScan(basePackages = "com.tyro.mapper", sqlSessionTemplateRef = "testSqlSessionTemplate")
@Profile("test")
public class TestDataSourceConfiguration {

	@Autowired
	private TestDBProperties testDBProperties;

	@Autowired
	private ApplicationContext context;

	@Bean(name = { "testDataSource" })
	@ConfigurationProperties(prefix = "spring.test.datasource")
	public DataSource dataSource() {
		return testDBProperties.getDataSource();
	}

	@Bean("testSqlSessionTemplate")
	public SqlSessionTemplate sqlSessionTemplate(@Qualifier("testDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setConfigLocation(context.getResource(context.getEnvironment().getProperty("mybatis.config")));
		return new SqlSessionTemplate(bean.getObject());
	}

	@Bean(name = "testDataSourceInitializer")
	public DataSourceInitializer dataSourceInitializer(@Qualifier("testDataSource") DataSource dataSource) {
		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		dataSourceInitializer.setDataSource(dataSource);
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();

		Optional.ofNullable(testDBProperties.getDataSource().getSchema()).map(schema -> context.getResource(schema))
				.ifPresent(resource -> databasePopulator.addScript(resource));
		Optional.ofNullable(testDBProperties.getDataSource().getData()).map(data -> context.getResource(data))
				.ifPresent(resource -> databasePopulator.addScript(resource));

		dataSourceInitializer.setDatabasePopulator(databasePopulator);
		dataSourceInitializer.setEnabled(true);
		return dataSourceInitializer;
	}
}
