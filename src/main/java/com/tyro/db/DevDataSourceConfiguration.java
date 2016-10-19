package com.tyro.db;

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
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;

@Configuration
@MapperScan(basePackages = "com.tyro.mapper", sqlSessionTemplateRef = "devSqlSessionTemplate")
@Profile("dev")
public class DevDataSourceConfiguration {

	@Autowired
	private DevDBProperties devDBProperties;

	@Autowired
	private ApplicationContext context;

	@Bean(name = { "dataSource", "devDataSource" })
	@ConfigurationProperties(prefix = "spring.dev.datasource")
	@Primary
	public DataSource dataSource() {
		return devDBProperties.getDataSource();
	}

	@Bean("devSqlSessionTemplate")
	public SqlSessionTemplate sqlSessionTemplate(@Qualifier("devDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setConfigLocation(context.getResource(context.getEnvironment().getProperty("mybatis.config")));
		return new SqlSessionTemplate(bean.getObject());
	}

	@Bean(name = "devDataSourceInitializer")
	public DataSourceInitializer dataSourceInitializer(@Qualifier("devDataSource") DataSource dataSource) {
		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		dataSourceInitializer.setDataSource(dataSource);
		dataSourceInitializer.setEnabled(true);
		return dataSourceInitializer;
	}
}
